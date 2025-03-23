package com.example.services;

import com.example.common.eRole;
import com.example.dto.ServiceCreateResponse;
import com.example.dto.UserCreateResponse;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public class ServiceProvider {
    private UserService userService;
    private MicroServiceService microService;

    public ServiceProvider() {
    }

    public UserCreateResponse createPermissionsForUser(String email, Set<eRole> permissions) {
        return userService.createPermissionsForUser(email, permissions);
    }

    public ServiceCreateResponse createPermissionsForService(String serviceEndpointIdentifier, Set<eRole> permissions) {
        return microService.createPermissionsForService(serviceEndpointIdentifier, permissions);
    }


    public MicroServiceService getMicroService() {
        return microService;
    }

    public UserService getUserService() {
        return userService;
    }

    public ServiceProvider setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }

    public ServiceProvider setMicroService(MicroServiceService microService) {
        this.microService = microService;
        return this;
    }

    public boolean isEligible(String email, String serviceEndpointIdentifier) {
        Optional<Set<eRole>> maybeUserPermissions = userService.getUsersPermissions(email);
        if (maybeUserPermissions.isEmpty()) return false;

        return microService
                .getServicePermissions(serviceEndpointIdentifier)
                .filter(permissions -> permissions.stream().anyMatch(maybeUserPermissions.get()::contains))
                .isPresent();
    }
}
