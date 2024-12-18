package com.infracow.program.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infracow.program.models.Usuario;
import com.infracow.program.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Usuario addUser(Usuario user) {
        return repository.save(user);
    }

    public Optional<Usuario> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
