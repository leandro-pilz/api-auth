package com.apiauth.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Utils {

    public static LocalDateTime newDate() {
        return LocalDateTime.now().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();
    }

    public static UserDetails getUserLogged() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
