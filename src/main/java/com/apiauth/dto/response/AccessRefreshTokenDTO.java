package com.apiauth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessRefreshTokenDTO {
    @JsonProperty(value = "accessToken")
    private String accessToken;

    @JsonProperty(value = "refreshToken")
    private String refreshToken;
}
