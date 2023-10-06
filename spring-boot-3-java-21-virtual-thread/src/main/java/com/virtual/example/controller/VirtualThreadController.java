package com.virtual.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class VirtualThreadController {

    @GetMapping
    public ResponseEntity<?> getVirtualThread() throws InterruptedException {

        var threadName = Thread.currentThread().toString();

        var response = STR."""
                {
                   "thradName" :\{threadName}
                   "port" : "8091"
                   "applicationName" : "virtual-thread"
                }
                """;

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

}

