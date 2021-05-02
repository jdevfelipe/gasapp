package com.gasapp.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get() {
        return ResponseEntity.ok("RUNNING");
    }
}
