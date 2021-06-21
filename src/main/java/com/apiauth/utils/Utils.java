package com.apiauth.utils;

import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Utils {

    @NonNull
    public static LocalDateTime newDateAmericaSaoPaulo() {
        return newDate(ZoneId.of("America/Sao_Paulo"));
    }

    @NonNull
    private static LocalDateTime newDate(ZoneId zoneId) {
        return LocalDateTime.now(zoneId);
    }
}
