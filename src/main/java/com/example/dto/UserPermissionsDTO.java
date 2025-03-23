package com.example.dto;

import com.example.common.eRole;

import java.util.Set;

public class UserPermissionsDTO {
    public UserPermissionsDTO(String email, Set<eRole> permissions) {
        this.email = email;
        this.permissions = permissions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<eRole> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<eRole> permissions) {
        this.permissions = permissions;
    }

    private String email;
    private Set<eRole> permissions;

}
