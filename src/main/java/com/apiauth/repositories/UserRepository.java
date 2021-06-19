package com.apiauth.repositories;

import com.apiauth.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Transactional(readOnly = true)
    @Query(value = "" +
            "SELECT user " +
            "  FROM UserEntity user " +
            " WHERE user.email = :email")
    Optional<UserEntity> findByEmail(@Param(value = "email") String email);

    @Transactional(readOnly = true)
    @Query(value = "" +
            "SELECT user " +
            "  FROM UserEntity user " +
            " WHERE user.uuid = :uuid ")
    Optional<UserEntity> findByUuid(UUID uuid);
}
