package com.coffeebrew.stubserver.repository;

import com.coffeebrew.stubserver.models.EndpointMock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EndpointRepository extends CrudRepository<EndpointMock, String> {
    List<EndpointMock> findByUrl(String uri);
}
