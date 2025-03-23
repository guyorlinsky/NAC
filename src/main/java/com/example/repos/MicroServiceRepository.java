package com.example.repos;

import com.example.models.MicroService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MicroServiceRepository extends JpaRepository<MicroService, Long>  {
    Optional<MicroService> findByServiceEndpointIdentifier(String serviceEndpointIdentifier);
}
