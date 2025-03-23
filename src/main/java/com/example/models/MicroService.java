package com.example.models;

import com.example.common.eRole;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "services")
public class MicroService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceEndpointIdentifier;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "service_roles", joinColumns = @JoinColumn(name = "service_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<eRole> permissions;

    public MicroService(String serviceEndpointIdentifier, Set<eRole> permissions) {
        this.permissions = permissions;
        this.serviceEndpointIdentifier = serviceEndpointIdentifier;
    }

    public MicroService() {
    }

    public Long getId() {
        return id;
    }

    public Set<eRole> getPermissions() {
        return permissions;
    }

    public String getServiceEndpointIdentifier() {
        return serviceEndpointIdentifier;
    }

    public void setServiceEndpointIdentifier(String serviceEndpointIdentifier) {
        this.serviceEndpointIdentifier = serviceEndpointIdentifier;
    }
}
