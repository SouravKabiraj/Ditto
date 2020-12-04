package com.coffeebrew.stubserver.services;

import com.coffeebrew.stubserver.models.EndpointMock;
import com.coffeebrew.stubserver.repository.EndpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndpointService {

    @Autowired
    EndpointRepository endpointRepository;

    public EndpointMock create(EndpointMock endpointMock) {
        return endpointRepository.save(endpointMock);
    }

    public List<EndpointMock> getAll() {
        return (List<EndpointMock>) endpointRepository.findAll();
    }

    public void remove(String id) {
        endpointRepository.deleteById(id);
    }
}
