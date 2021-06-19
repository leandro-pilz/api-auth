package com.apiauth.controllers;

import com.apiauth.dto.response.AccessRefreshTokenDTO;
import com.apiauth.entities.UserEntity;
import com.apiauth.services.AuthService;
import com.apiauth.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.apiauth.utils.ApiRoutes.REFRESH_ROUTE;

@RestController
@RequestMapping(value = REFRESH_ROUTE)
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccessRefreshTokenDTO createNewAccessRefreshToken() {
        final UserEntity user = (UserEntity) Utils.getUserLogged();
        return authService.createNewAccessRefreshToken(user.getUuid());
    }
}
