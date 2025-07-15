package com.example.demo.dto;

import com.example.demo.model.Game;
import com.example.demo.model.Gender;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private Set<Game> games;
    private int age;
    private String about;
    private Gender gender;
}
