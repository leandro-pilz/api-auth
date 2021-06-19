package com.apiauth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto {

    @JsonProperty("login")
    private String login;

    @JsonProperty("senha")
    private String password;
}
