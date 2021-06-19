package com.apiauth.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsServiceCustom extends UserDetailsService {
    UserDetails loadUserByUuid(String uuid) throws UsernameNotFoundException;
}
