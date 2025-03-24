package com.example.controllers;

import com.example.dto.ServiceCreateResponse;
import com.example.dto.ServicePermissionsDTO;
import com.example.dto.UserCreateResponse;
import com.example.dto.UserPermissionsDTO;
import com.example.models.MicroService;
import com.example.models.User;
import com.example.services.MicroServiceService;
import com.example.services.ServiceProvider;
import com.example.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppControllerImpl implements AppController{
    private final ServiceProvider service;

    public AppControllerImpl(UserService userService, MicroServiceService microService) {
        this.service = new ServiceProvider()
                .setUserService(userService)
                .setMicroService(microService);
    }

    @Override
    public ResponseEntity<UserCreateResponse> createPermissionsForUser(UserPermissionsDTO request) {
         return ResponseEntity.ok(service.createPermissionsForUser(request.getEmail(), request.getPermissions()));
    }

    @Override
    public ResponseEntity<List<User>> readAllUsers() {
        List<User> Users = service.getUserService().getAllUsers();
        return ResponseEntity.ok(Users);
    }

    @Override
    public ResponseEntity<ServiceCreateResponse> createPermissionsForService(ServicePermissionsDTO request) {
        return ResponseEntity.ok(service.createPermissionsForService(request.getServiceEndpointIdentifier(), request.getPermissions()));
    }

    @Override
    public ResponseEntity<List<MicroService>> readAllServiceEndpoints() {
        List<MicroService> serviceEndpoints = service.getMicroService().getAllServiceEndpoints();
        return ResponseEntity.ok(serviceEndpoints);
    }

    @Override
    public ResponseEntity<Void> isEligible(String email, String serviceEndpointIdentifier) {
        if (service.isEligible(email, serviceEndpointIdentifier))
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }
}
