package com.coffeebrew.stubserver.controllers;

import com.coffeebrew.stubserver.models.EndpointMock;
import com.coffeebrew.stubserver.services.MockEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping(value = "/**/{path:[^\\.]*}")
public class MockEndpointController {

    @Autowired
    MockEndpointService mockEndpointService;

    @GetMapping()
    public ResponseEntity<String> get(HttpServletRequest httpServletRequest) {
        String uri = httpServletRequest.getRequestURI();
        Optional<EndpointMock> endpointMock = mockEndpointService.getResponseByUrl(uri, HttpMethod.GET);
        return endpointMock
                .map(mock -> new ResponseEntity<>(mock.getBody(), HttpStatus.valueOf(mock.getStatus())))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PutMapping()
    public ResponseEntity<String> put(HttpServletRequest httpServletRequest) {
        String uri = httpServletRequest.getRequestURI();
        Optional<EndpointMock> endpointMock = mockEndpointService.getResponseByUrl(uri, HttpMethod.PUT);
        return endpointMock
                .map(mock -> new ResponseEntity<>(mock.getBody(), HttpStatus.valueOf(mock.getStatus())))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

    @PostMapping()
    public ResponseEntity<String> post(HttpServletRequest httpServletRequest) {
        String uri = httpServletRequest.getRequestURI();
        Optional<EndpointMock> endpointMock = mockEndpointService.getResponseByUrl(uri, HttpMethod.POST);
        return endpointMock
                .map(mock -> new ResponseEntity<>(mock.getBody(), HttpStatus.valueOf(mock.getStatus())))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

    @DeleteMapping()
    public ResponseEntity<String> delete(HttpServletRequest httpServletRequest) {
        String uri = httpServletRequest.getRequestURI();
        Optional<EndpointMock> endpointMock = mockEndpointService.getResponseByUrl(uri, HttpMethod.DELETE);
        return endpointMock
                .map(mock -> new ResponseEntity<>(mock.getBody(), HttpStatus.valueOf(mock.getStatus())))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }
}
