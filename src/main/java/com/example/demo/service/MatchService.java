package com.example.demo.service;

import com.example.demo.dto.SearchPreferencesDto;
import com.example.demo.model.SearchPreferences;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final SearchPreferencesService searchPreferencesService;
    private final UserService userService;

    public List<User> findMatches() {
        final SearchPreferencesDto prefs = searchPreferencesService.getPreferencesForCurrentUser();
        final LocalDate minBirthDate = LocalDate.now().minusYears(prefs.getMinAge()).withMonth(1).withDayOfMonth(1);
        final LocalDate maxBirthDate = LocalDate.now().minusYears(prefs.getMaxAge()).withMonth(1).withDayOfMonth(1);

        return userService.findCompatibleUsers(
                prefs.getGender(),
                minBirthDate,
                maxBirthDate);
    }
}
