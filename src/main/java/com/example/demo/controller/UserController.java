package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping
    public UserDto getUser() {
        return userService.getCurrentUserDto();
    }

    @PostMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateCurrent(userDto);
    }
}
