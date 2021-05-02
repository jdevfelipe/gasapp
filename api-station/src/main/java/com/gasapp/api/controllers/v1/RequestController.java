package com.gasapp.api.controllers.v1;

import com.gasapp.api.exceptions.NotAllowedException;
import com.gasapp.api.services.RequestService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/request")
@RestController
public class RequestController {
    @Autowired
    private RequestService service;

    private static final String UNAUTHORIZED = "UNAUTHORIZED";
    private static final String TOKEN = "PY$y7W-U#Wb^L$eq\"2-U+r@=;^_^6{=,";

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity request(@RequestHeader(value = "token") String token, @RequestBody String cookie) throws Exception {
        if (!StringUtils.equals(token, TOKEN)) {
            throw new NotAllowedException(UNAUTHORIZED);
        }
        service.request(cookie);
        return ResponseEntity.ok("OK");
    }
}
