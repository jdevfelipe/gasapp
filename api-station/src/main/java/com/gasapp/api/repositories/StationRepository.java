package com.gasapp.api.repositories;

import com.gasapp.api.models.Station;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends MongoRepository<Station, String> {
    Station findByNameNoCaps(String name);
}
