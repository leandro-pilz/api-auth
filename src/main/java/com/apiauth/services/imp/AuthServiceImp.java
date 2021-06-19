package com.apiauth.services.imp;

import com.apiauth.dto.response.AccessRefreshTokenDTO;
import com.apiauth.security.jwt.JWTUtil;
import com.apiauth.services.AuthService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service(value = "authService")
public class AuthServiceImp implements AuthService {

    @Override
    public AccessRefreshTokenDTO createNewAccessRefreshToken(@NonNull UUID uuid) {
        return AccessRefreshTokenDTO
                .builder()
                .accessToken(JWTUtil.accessToken(uuid))
                .refreshToken(JWTUtil.refreshToken(uuid))
                .build();
    }
}
