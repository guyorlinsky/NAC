package com.example.dto;

import com.example.models.MicroService;

public class ServiceCreateResponse {
    private MicroService service;

    public ServiceCreateResponse() {}
    public ServiceCreateResponse(MicroService service) {
        this.service = service;
    }

    public MicroService getService() {
        return service;
    }

    public ServiceCreateResponse setService(MicroService service) {
        this.service = service;
        return this;
    }
}
