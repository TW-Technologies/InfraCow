package com.infracow.program.infra.security;

import com.infracow.program.models.Usuario;
import com.infracow.program.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> userOpt = repository.findByEmail(username);

        if (userOpt.isPresent()) {
            Usuario user = userOpt.get();
            return User.builder()
                    .username(user.getEmail())
                    .password(user.getSenha())
                    .roles("")
                    .build();
        }
        return null;
    }
}
