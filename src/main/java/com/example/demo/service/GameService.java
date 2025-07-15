package com.example.demo.service;


import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository repository;

    public Set<Game> getGames() {
        return Set.copyOf(repository.findAll());
    }

    public Game addGame(String title) {
        Game game = new Game();
        game.setTitle(title);
        return repository.save(game);
    }

    public void deleteGame(Long id) {
        repository.deleteById(id);
    }
}
