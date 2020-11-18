package com.coffeebrew.stubserver.services;

import com.coffeebrew.stubserver.models.EndpointMock;
import com.coffeebrew.stubserver.repository.EndpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MockEndpointService {
    @Autowired
    EndpointRepository repository;

    public Optional<EndpointMock> getResponseByUrl(String uri, HttpMethod method) {
        List<EndpointMock> endpoints = repository.findByUrl(uri);
        for (EndpointMock endpoint : endpoints) {
            if (endpoint.getMethod().equals(method)) {
                return Optional.of(endpoint);
            }
        }
        return Optional.empty();
    }
}
