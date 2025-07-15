package com.example.demo.controller;

import com.example.demo.dto.SearchPreferencesDto;
import com.example.demo.service.SearchPreferencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/search-preferences")
@RequiredArgsConstructor
public class SearchPreferencesController {

    private final SearchPreferencesService searchPreferencesService;

    @GetMapping
    public ResponseEntity<SearchPreferencesDto> searchPreferences() {
        return ResponseEntity.ok().body(searchPreferencesService.getPreferencesForCurrentUser());
    }

    @PutMapping("/change")
    public SearchPreferencesDto updatePreferences(@RequestBody SearchPreferencesDto searchPreferencesDto) {
        searchPreferencesService.updatePreferences(searchPreferencesDto);
        return searchPreferencesDto;
    }
}
