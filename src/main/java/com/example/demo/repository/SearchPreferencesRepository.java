package com.example.demo.repository;

import com.example.demo.model.SearchPreferences;
import com.example.demo.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SearchPreferencesRepository extends JpaRepository<SearchPreferences, Long> {
    @NotNull Optional<SearchPreferences> findById(@NotNull Long id);

}
