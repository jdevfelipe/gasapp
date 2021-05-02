package com.api.apiauth.repositories;

import com.api.apiauth.models.Station;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StationRepository extends MongoRepository<Station, String> {

    @Query(value="{'address.district' : {$regex: /?0/,$options:'i'}}", fields="{ 'prices' : 0}")
    public Page<Station> getStationsByDistrict(String district, Pageable pageable);
}
