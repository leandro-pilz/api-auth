package com.apiauth.services;

import com.apiauth.dto.response.AccessRefreshTokenDTO;

import java.util.UUID;

public interface AuthService {
    AccessRefreshTokenDTO createNewAccessRefreshToken(UUID uuid);
}
