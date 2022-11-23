package com.example.pbs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PBSController {

    @PostMapping("/getGreetings")
    public ResponseEntity<String> getGreetings(@RequestBody String str) {
        System.out.println(str);
        return new ResponseEntity<>("Hello from server", HttpStatus.OK);
    }

    @GetMapping("/getGr")
    public String hi() {
        return "hello";
    }
}