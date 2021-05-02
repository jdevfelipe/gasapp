package com.api.apiauth.controllers.v1;

import com.api.apiauth.models.Station;
import com.api.apiauth.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/station")
public class StationController {

    @Autowired
    private StationService service;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value="/get-stations", method = RequestMethod.GET)
    public ResponseEntity getStationsByDistrict(@RequestHeader(value = "page", defaultValue = "0") int page, @RequestHeader(value = "district") String district) throws Exception {
        Map<String, Object> response = new HashMap<>();
        Page<Station> stations = service.getStationsByDistrict(district, page, 10);
        response.put("stations", stations.get());
        response.put("currentPage", stations.getNumber());
        response.put("totalItems", stations.getTotalElements());
        response.put("totalPages", stations.getTotalPages());
        return ResponseEntity.ok(response);
    }
}
