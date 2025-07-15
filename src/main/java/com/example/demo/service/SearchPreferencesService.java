package com.example.demo.service;

import com.example.demo.dto.SearchPreferencesDto;
import com.example.demo.mapper.SearchPreferencesMapper;
import com.example.demo.model.SearchPreferences;
import com.example.demo.model.User;
import com.example.demo.repository.SearchPreferencesRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchPreferencesService {

    private final SearchPreferencesRepository preferencesRepository;
    private final UserService userService;
    private final SearchPreferencesMapper preferencesMapper;

    public void updatePreferences(SearchPreferencesDto searchPreferencesDto) {
        final User user = userService.getCurrentUser();

        SearchPreferences prefs = preferencesRepository
                .findById(user.getId())
                .orElse(SearchPreferences.builder().user(user).build());
        preferencesMapper.updateSearchPreferences(prefs, searchPreferencesDto);
        preferencesRepository.save(prefs);
    }

    public SearchPreferencesDto getPreferencesForCurrentUser() {
        SearchPreferences prefs = preferencesRepository
                .findById(userService.getCurrentUser().getId())
                .orElse(new SearchPreferences());
        return preferencesMapper.toSearchPreferencesDto(prefs);
    }

    public SearchPreferencesDto getPreferences(Long id) {
        final SearchPreferences prefs = preferencesRepository
                .findById(id).orElseThrow();
        return preferencesMapper.toSearchPreferencesDto(prefs);
    }
}
