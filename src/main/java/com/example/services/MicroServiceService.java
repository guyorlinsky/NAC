package com.example.services;

import com.example.common.eRole;
import com.example.dto.ServiceCreateResponse;
import com.example.models.MicroService;
import com.example.repos.MicroServiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MicroServiceService {

    private final MicroServiceRepository repository;

    public MicroServiceService(MicroServiceRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ServiceCreateResponse createPermissionsForService(String serviceEndpointIdentifier, Set<eRole> permissions) {
        MicroService service = new MicroService(serviceEndpointIdentifier, permissions);
        return new ServiceCreateResponse().setService(repository.save(service));
    }

    public List<MicroService> getAllServiceEndpoints() {
        return repository.findAll();
    }

    public Optional<Set<eRole>> getServicePermissions(String serviceEndpointIdentifier) {
        return repository.findByServiceEndpointIdentifier(serviceEndpointIdentifier).map(MicroService::getPermissions);
    }
}
