package com.platform.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class PlatformThreadController {

    @GetMapping
    public ResponseEntity<?> getPlatformThread() throws InterruptedException {

        var threadName = Thread.currentThread().getName();

        var response = STR."""
                {
                   "thradName" :\{threadName}
                   "port" : "8090"
                   "applicationName" : "platform-thread"
                }
                """;

       return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
