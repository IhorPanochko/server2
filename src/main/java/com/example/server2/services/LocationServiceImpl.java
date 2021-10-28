package com.example.server2.services;

import com.example.server2.documents.Locations;
import com.example.server2.dto.LocationDto;
import com.example.server2.repository.LocationsRepository;
import com.example.server2.services.interfaces.LocationService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationsRepository repository;

    public LocationServiceImpl(LocationsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<LocationDto> getByZipList(List<Long> zipIdList) {
        return repository.findAllByZipIn(zipIdList).flatMap(this::toDto);
    }

    @Override
    public void addLocations() {
        Locations locations = new Locations("Lviv", 1L);
        Locations locations1 = new Locations("Odessa", 2L);
        Locations locations2 = new Locations("Kyiv", 3L);
        Locations locations3 = new Locations("Harkiv", 4L);
        Locations locations4 = new Locations("Rivne", 5L);
        Locations locations5 = new Locations("Syhiv", 6L);
        List<Locations> locationsList = Arrays.asList(locations, locations1, locations2, locations3, locations4, locations5);
        repository.saveAll(locationsList).subscribe();
    }

    private Mono<LocationDto> toDto(Locations locations) {
        return Mono.just(new LocationDto(locations.getId(), locations.getCity(), locations.getZip()));
    }
}
