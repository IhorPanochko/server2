package com.example.server2.services.interfaces;

import com.example.server2.dto.UserDto;
import reactor.core.publisher.Flux;

import java.util.List;

public interface UsersService {

    Flux<UserDto> getUsersByIdList(List<String> userIds);

    void addUsers();

}
