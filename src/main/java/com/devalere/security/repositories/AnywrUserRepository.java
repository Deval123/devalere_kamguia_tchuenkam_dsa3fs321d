package com.devalere.security.repositories;

import com.devalere.security.user.AnywrUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AnywrUserRepository extends JpaRepository<AnywrUser, Integer> {
    //@Query(value = "select u from AnywrUser u where u.email = :email")
    Optional<AnywrUser> findAnywrUserByEmail(@Param("email") String email);

}
