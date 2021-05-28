package com.coffeebrew.stubserver.controllers;

import com.coffeebrew.stubserver.models.EndpointMock;
import com.coffeebrew.stubserver.services.MockEndpointService;
import com.google.gson.Gson;
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
@CrossOrigin(origins = "*")
public class MockEndpointController {

    @Autowired
    MockEndpointService mockEndpointService;

    @GetMapping()
    public ResponseEntity<Object> get(HttpServletRequest httpServletRequest) {
        Gson gson = new Gson();
        String url = httpServletRequest.getRequestURI();
        String query = httpServletRequest.getQueryString();
        Optional<EndpointMock> endpointMock = mockEndpointService.getResponseByUrl(url, query, HttpMethod.GET);
        return endpointMock
                .map(
                        mock -> new ResponseEntity<>(
                                gson.fromJson(mock.getBody(), Object.class),
                                HttpStatus.valueOf(mock.getStatus())))
                .orElseGet(
                        () -> new ResponseEntity<>(
                                null, HttpStatus.NOT_FOUND));
    }

    @PutMapping()
    public ResponseEntity<Object> put(HttpServletRequest httpServletRequest) {
        Gson gson = new Gson();
        String uri = httpServletRequest.getRequestURI();
        String query = httpServletRequest.getQueryString();
        Optional<EndpointMock> endpointMock = mockEndpointService.getResponseByUrl(uri, query, HttpMethod.PUT);
        return endpointMock
                .map(mock -> new ResponseEntity<>(gson.fromJson(mock.getBody(), Object.class), HttpStatus.valueOf(mock.getStatus())))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

    @PostMapping()
    public ResponseEntity<Object> post(HttpServletRequest httpServletRequest) {
        Gson gson = new Gson();
        String uri = httpServletRequest.getRequestURI();
        String query = httpServletRequest.getQueryString();
        Optional<EndpointMock> endpointMock = mockEndpointService.getResponseByUrl(uri, query, HttpMethod.POST);
        return endpointMock
                .map(mock -> new ResponseEntity<>(gson.fromJson(mock.getBody(), Object.class), HttpStatus.valueOf(mock.getStatus())))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

    @DeleteMapping()
    public ResponseEntity<Object> delete(HttpServletRequest httpServletRequest) {
        Gson gson = new Gson();
        String uri = httpServletRequest.getRequestURI();
        String query = httpServletRequest.getQueryString();
        Optional<EndpointMock> endpointMock = mockEndpointService.getResponseByUrl(uri, query, HttpMethod.DELETE);
        return endpointMock
                .map(mock -> new ResponseEntity<>(gson.fromJson(mock.getBody(), Object.class), HttpStatus.valueOf(mock.getStatus())))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }
}
