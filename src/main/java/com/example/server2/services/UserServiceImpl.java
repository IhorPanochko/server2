package com.example.server2.services;

import com.example.server2.documents.Users;
import com.example.server2.dto.UserDto;
import com.example.server2.repository.UsersRepository;
import com.example.server2.services.interfaces.UsersService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Flux<UserDto> getUsersByIdList(List<String> userIds) {
        return usersRepository.findAllByIdIn(userIds).flatMap(this::toDto);
    }


    @Override
    public void addUsers() {
        Users users = new Users("Ihor");
        Users users1 = new Users("Ivan");
        Users users2 = new Users("Oleh");
        Users users3 = new Users("Vova");
        Users users4 = new Users("Stepan");
        Users users5 = new Users("Vitalik");
        List<Users> list = Arrays.asList(users, users1, users2, users3, users4, users5);
       usersRepository.saveAll(list).subscribe();
    }

    private Mono<UserDto> toDto(Users user) {
        return Mono.just(new UserDto(user.getId(), user.getName()));
    }
}
