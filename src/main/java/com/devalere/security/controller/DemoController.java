package com.devalere.security.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.devalere.security.utils.Constants.USER_DEMO_ENDPOINT;

@RestController
@RequestMapping(USER_DEMO_ENDPOINT)
public class DemoController {

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from anywr test");
    }
}
