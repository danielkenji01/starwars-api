package com.starwars.api;

import com.starwars.dto.Film;
import com.starwars.dto.ListWrapper;
import com.starwars.service.FilmsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/films")
public class FilmsController {

    private final FilmsService filmsService;

    @GetMapping
    public ResponseEntity<ListWrapper<Film>> getAll() {
        return ResponseEntity.ok(filmsService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getById(@PathVariable final Integer id) {
        return ResponseEntity.ok(filmsService.getById(id));
    }

}
