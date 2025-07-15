package com.example.demo.dto;

import com.example.demo.model.Game;
import com.example.demo.model.Gender;
import lombok.Data;

import java.util.Set;

@Data
public class SearchPreferencesDto {
    private Gender gender;
    private int minAge;
    private int maxAge;
    private Set<Game> preferredGames;
}
