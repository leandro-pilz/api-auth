package com.apiauth.services.imp;

import com.apiauth.entities.UserEntity;
import com.apiauth.repositories.UserRepository;
import com.apiauth.services.UserDetailsServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsServiceCustom {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(@NonNull String login) throws UsernameNotFoundException {
        final Optional<UserEntity> user = repository.findByEmail(login);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não inexistente.");
        }

        if (!user.get().getStatus()) {
            throw new UsernameNotFoundException("Usuário bloqueado, entre em contato com o administrador do sistema.");
        }

        if (!user.get().getCompany().getStatus()) {
            throw new UsernameNotFoundException("Empresa bloqueada, entre em contato com o administrador do sistema.");
        }

        return user.get();
    }

    @Override
    public UserDetails loadUserByUuid(String uuid) throws UsernameNotFoundException {
        final Optional<UserEntity> user = repository.findByUuid(UUID.fromString(uuid));
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Usuário inexistente");
        } else if (!user.get().getStatus()) {
            throw new UsernameNotFoundException("Usuário bloqueado, entre em contato com o administrador do sistema.");
        }
        return user.get();
    }
}
