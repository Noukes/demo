package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "search_preferences")
public class SearchPreferences {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @Enumerated
    Gender gender;

    private int minAge;
    private int maxAge;

    @ManyToMany
    @JoinTable(
            name = "preferred_games",
            joinColumns = @JoinColumn(name = "preferences_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private Set<Game> preferredGames;
}
