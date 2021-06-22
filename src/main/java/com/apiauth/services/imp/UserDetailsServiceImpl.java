package com.apiauth.services.imp;

import com.apiauth.entities.UserEntity;
import com.apiauth.repositories.UserRepository;
import com.apiauth.services.UserDetailsServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.apiauth.utils.MessageExceptions.*;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsServiceCustom {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(@NonNull String login) throws UsernameNotFoundException {
        final UserEntity user = repository.findByEmail(login)
                .orElseThrow(() -> new UsernameNotFoundException(USER_NOTFOUND));

        if (!user.getStatus()) {
            throw new UsernameNotFoundException(USER_BLOCKED);
        }

        if (!user.getCompany().getStatus()) {
            throw new UsernameNotFoundException(COMPANY_BLOCKED);
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUuid(String uuid) throws UsernameNotFoundException {
        final UserEntity user = repository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new UsernameNotFoundException(USER_NOTFOUND));

        if (!user.getStatus()) {
            throw new UsernameNotFoundException(USER_BLOCKED);
        }

        return user;
    }
}
