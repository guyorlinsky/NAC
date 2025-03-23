package com.example.dto;

import com.example.common.eRole;

import java.util.Set;

public class ServicePermissionsDTO {

    private String serviceEndpointIdentifier;
    private Set<eRole> permissions;

    public Set<eRole> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<eRole> permissions) {
        this.permissions = permissions;
    }

    public ServicePermissionsDTO(String serviceEndpointIdentifier, Set<eRole> permissions) {
        this.serviceEndpointIdentifier = serviceEndpointIdentifier;
        this.permissions = permissions;
    }

    public String getServiceEndpointIdentifier() {
        return serviceEndpointIdentifier;
    }

    public void setServiceEndpointIdentifier(String serviceEndpointIdentifier) {
        this.serviceEndpointIdentifier = serviceEndpointIdentifier;
    }

}
