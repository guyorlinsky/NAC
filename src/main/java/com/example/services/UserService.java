package com.example.services;

import com.example.common.eRole;
import com.example.dto.UserCreateResponse;
import com.example.models.User;
import com.example.repos.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserCreateResponse createPermissionsForUser(String email, Set<eRole> permissions) {
        User user = new User(email, permissions);
        return new UserCreateResponse().setUser(repository.save(user));
    }

    public Optional<Set<eRole>> getUsersPermissions(String email) {
        return repository.findByEmail(email).map(User::getPermissions);
    }
}
