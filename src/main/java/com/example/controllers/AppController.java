package com.example.controllers;

import com.example.dto.ServiceCreateResponse;
import com.example.dto.ServicePermissionsDTO;
import com.example.dto.UserCreateResponse;
import com.example.dto.UserPermissionsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface AppController {
    String CREATE_PERMISSIONS_FOR_USER = "/users/permissions";
    String CREATE_PERMISSIONS_FOR_SERVICE = "/services/permissions";
    String IS_ELIGIBLE = "/auth";

    @PostMapping(CREATE_PERMISSIONS_FOR_USER)
    ResponseEntity<UserCreateResponse> createPermissionsForUser(@RequestBody UserPermissionsDTO request);

    @PostMapping(CREATE_PERMISSIONS_FOR_SERVICE)
    ResponseEntity<ServiceCreateResponse> createPermissionsForService(@RequestBody ServicePermissionsDTO request);

    @GetMapping(IS_ELIGIBLE)
    ResponseEntity<Void> isEligible(@RequestParam String email, @RequestParam String serviceEndpointIdentifier);

}
