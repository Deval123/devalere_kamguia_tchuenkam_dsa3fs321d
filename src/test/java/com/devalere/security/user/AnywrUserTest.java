package com.devalere.security.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class AnywrUserTest {

    @Test
    public void testAnywrUserCreation() {
        // Create test data
        Integer id = 1;
        String firstName = "John";
        String lastName = "Doe";
        String email = "johndoe@example.com";
        String password = "password";
        Role role = Role.USER;

        // Create AnywrUser instance
        AnywrUser user = AnywrUser.builder()
                .id(id)
                .firstname(firstName)
                .lastname(lastName)
                .email(email)
                .password(password)
                .role(role)
                .build();

        // Assert values
        Assertions.assertEquals(id, user.getId());
        Assertions.assertEquals(firstName, user.getFirstname());
        Assertions.assertEquals(lastName, user.getLastname());
        Assertions.assertEquals(email, user.getEmail());
        Assertions.assertEquals(password, user.getPassword());
        Assertions.assertEquals(role, user.getRole());

        Collection<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(role.name()));
        Assertions.assertEquals(authorities, user.getAuthorities());
        Assertions.assertEquals(email, user.getUsername());
        Assertions.assertTrue(user.isAccountNonExpired());
        Assertions.assertTrue(user.isAccountNonLocked());
        Assertions.assertTrue(user.isCredentialsNonExpired());
        Assertions.assertTrue(user.isEnabled());
    }
}
