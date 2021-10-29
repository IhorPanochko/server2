package com.example.server2.controllers;

import com.example.server2.dto.UserDto;
import com.example.server2.services.interfaces.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;


@RestController()
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "/addUsers")
    public void addUsers() {
        usersService.addUsers();
    }

    @PostMapping(value = "/user/getByIds")
    public Flux<UserDto> getUsers(@RequestBody List<String> list) {
        return usersService.getUsersByIdList(list);
    }

}
