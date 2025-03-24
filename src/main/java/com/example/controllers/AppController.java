package com.example.controllers;

import com.example.dto.ServiceCreateResponse;
import com.example.dto.ServicePermissionsDTO;
import com.example.dto.UserCreateResponse;
import com.example.dto.UserPermissionsDTO;
import com.example.models.MicroService;
import com.example.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface AppController {
    String CREATE_PERMISSIONS_FOR_USER = "/users/permissions";
    String READ_ALL_USERS = "/users";
    String CREATE_PERMISSIONS_FOR_SERVICE = "/services/permissions";
    String READ_ALL_SERVICES = "/services";

    String IS_ELIGIBLE = "/auth";

    @PostMapping(CREATE_PERMISSIONS_FOR_USER)
    ResponseEntity<UserCreateResponse> createPermissionsForUser(@RequestBody UserPermissionsDTO request);

    @GetMapping(READ_ALL_USERS)
    ResponseEntity<List<User>> readAllUsers();

    @PostMapping(CREATE_PERMISSIONS_FOR_SERVICE)
    ResponseEntity<ServiceCreateResponse> createPermissionsForService(@RequestBody ServicePermissionsDTO request);

    @GetMapping(READ_ALL_SERVICES)
    ResponseEntity<List<MicroService>> readAllServiceEndpoints();

    @GetMapping(IS_ELIGIBLE)
    ResponseEntity<Void> isEligible(@RequestParam String email, @RequestParam String serviceEndpointIdentifier);

}
