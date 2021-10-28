package com.example.server2.services.interfaces;

import com.example.server2.dto.LocationDto;
import reactor.core.publisher.Flux;

import java.util.List;

public interface LocationService {

    Flux<LocationDto> getByZipList(List<Long> zipIdList);

    void addLocations();
}
