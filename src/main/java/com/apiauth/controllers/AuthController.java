package com.apiauth.controllers;

import com.apiauth.dto.response.AccessRefreshTokenDTO;
import com.apiauth.entities.UserEntity;
import com.apiauth.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.apiauth.utils.SystemConstants.ApiRoutes.REFRESH_ROUTE;

@RestController
@RequestMapping(value = REFRESH_ROUTE)
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccessRefreshTokenDTO createNewAccessRefreshToken(@AuthenticationPrincipal UserEntity user) {
        return authService.createNewAccessRefreshToken(user.getUuid());
    }
}
