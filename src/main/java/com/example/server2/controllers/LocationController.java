package com.example.server2.controllers;

import com.example.server2.dto.LocationDto;
import com.example.server2.services.interfaces.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping(value = "/addLocation")
    public void addUsers() {
        locationService.addLocations();
    }
    @PostMapping("/locations/getByZips")
    public Flux<LocationDto> getLocations(@RequestBody List<Long> list) {
        return locationService.getByZipList(list);
    }

}
