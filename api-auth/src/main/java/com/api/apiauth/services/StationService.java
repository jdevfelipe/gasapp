package com.api.apiauth.services;

import com.api.apiauth.exceptions.BadRequestException;
import com.api.apiauth.exceptions.NotFoundException;
import com.api.apiauth.models.Station;
import com.api.apiauth.repositories.StationRepository;
import com.api.apiauth.utils.StationUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StationService {
    @Autowired
    private StationRepository repository;

    @Autowired
    private StationUtil util;

    private static final String DISTRICT_IS_EMPTY = "DISTRICT_IS_EMPTY";
    private static final String STATION_NOT_FOUND = "STATION_NOT_FOUND";

    public Page<Station> getStationsByDistrict(String district, int page, int size) throws Exception {
        Pageable paging = PageRequest.of(page, size);

        if (StringUtils.isBlank(district)) {
            throw new BadRequestException(DISTRICT_IS_EMPTY);
        }

        Page<Station> stationsByDistrict;

        try {
            stationsByDistrict = repository.getStationsByDistrict(district, paging);
            //util.removeProceHistoric(stationsByDistrict.get().collect(Collectors.toList()));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


/*        if (stationsByDistrict.isEmpty()) {
            throw new NotFoundException(STATION_NOT_FOUND);
        }*/
        return stationsByDistrict;
    }
}
