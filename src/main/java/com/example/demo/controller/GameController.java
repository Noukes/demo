package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.service.GameService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/v1/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<Set<Game>> getGames() {
        return ResponseEntity.ok(gameService.getGames());
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Game> addGame(@RequestBody String title) {
        return ResponseEntity.ok(gameService.addGame(title));
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
    }
}
