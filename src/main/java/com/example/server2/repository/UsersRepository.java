package com.example.server2.repository;

import com.example.server2.documents.Users;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface UsersRepository extends ReactiveMongoRepository<Users, String> {

    Flux<Users> findAllByIdIn(List<String> userIds);

}
