package com.api.apiauth.controllers.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity get() {
        return ResponseEntity.ok("RUNNING");
    }
}
