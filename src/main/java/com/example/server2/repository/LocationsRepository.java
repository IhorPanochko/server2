package com.example.server2.repository;

import com.example.server2.documents.Locations;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface LocationsRepository extends ReactiveMongoRepository<Locations, String> {

    Flux<Locations> findAllByZipIn(List<Long> list);
}
