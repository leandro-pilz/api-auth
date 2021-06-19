package com.apiauth.security.jwt;

import com.apiauth.dto.request.AuthDto;
import com.apiauth.dto.response.AccessRefreshTokenDTO;
import com.apiauth.entities.UserEntity;
import com.apiauth.exceptions.StandardError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static com.apiauth.utils.ApiRoutes.BASE_URL;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());

        //Seta o enpoint de login.
        setFilterProcessesUrl(BASE_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            AuthDto login = new ObjectMapper().readValue(request.getInputStream(), AuthDto.class);

            if (StringUtils.isEmpty(login.getLogin()) || StringUtils.isEmpty(login.getPassword())) {
                throw new BadCredentialsException("Usuário ou senha não informado, verifique!");
            }

            Authentication auth = new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword(), new ArrayList<>());
            return authenticationManager.authenticate(auth);
        } catch (IOException e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication auth) throws IOException {

        final UserEntity user = (UserEntity) auth.getPrincipal();
        final AccessRefreshTokenDTO tokens = AccessRefreshTokenDTO
                .builder()
                .accessToken(JWTUtil.accessToken(user.getUuid()))
                .refreshToken(JWTUtil.refreshToken(user.getUuid()))
                .build();

        response.setStatus(HttpStatus.CREATED.value());
        response.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        response.addHeader("access-control-expose-headers", "Authorization");
        response.getOutputStream().print(new ObjectMapper().writeValueAsString(tokens));
    }

    private static class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {

        private String message;

        @Override
        public void onAuthenticationFailure(HttpServletRequest request,
                                            HttpServletResponse response,
                                            AuthenticationException e) throws IOException {
            message = e.getMessage();
            response.setStatus(401);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().append(json());
        }

        private String json() throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(StandardError.builder()
                    .timestamp(new Date().getTime())
                    .erro("Não Autorizado")
                    .messages(Collections.singletonList(message))
                    .path("/login")
                    .build());
        }
    }
}