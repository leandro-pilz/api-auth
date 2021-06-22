package com.apiauth.security.jwt;

import com.apiauth.services.UserDetailsServiceCustom;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.apiauth.utils.SystemConstants.Prefix.BEARER_PREFIX;
import static java.util.Objects.nonNull;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private final UserDetailsServiceCustom userDetailsService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, UserDetailsServiceCustom userDetailsService) {
        super(authenticationManager);
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader(AUTHORIZATION);
        if (header != null && header.startsWith(BEARER_PREFIX)) {
            UsernamePasswordAuthenticationToken auth = getAuthentication(header);
            if (nonNull(auth)) {
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        chain.doFilter(request, response);
    }

    @Nullable
    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        if (JWTUtil.isTokenValid(token)) {
            String userName = JWTUtil.getLogin(token);
            UserDetails user = userDetailsService.loadUserByUuid(userName);
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        }

        return null;
    }
}