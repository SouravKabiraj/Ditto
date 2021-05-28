package com.coffeebrew.stubserver.controllers;

import com.coffeebrew.stubserver.models.EndpointMock;
import com.coffeebrew.stubserver.services.EndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/endpoints")
@CrossOrigin(origins = "*")
public class EndpointController {

    @Autowired
    EndpointService endpointService;

    @PostMapping
    public ResponseEntity<EndpointMock> create(@RequestBody EndpointMock endpointMock) {
        return new ResponseEntity<>(endpointService.create(endpointMock), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<EndpointMock>> getAll() {
        return new ResponseEntity<>(endpointService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable String id) {
        endpointService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
