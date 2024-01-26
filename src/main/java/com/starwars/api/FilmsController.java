package com.starwars.api;

import com.starwars.dto.Film;
import com.starwars.dto.ListWrapper;
import com.starwars.service.FilmsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/films")
@Tag(name = "Films", description = "Films API")
public class FilmsController {

    private final FilmsService filmsService;

    @Operation(summary = "Get all Films", tags = { "Films" })
    @GetMapping
    public ResponseEntity<ListWrapper<Film>> getAll(@RequestParam(required = false, defaultValue = "1") final Integer page) {
        return ResponseEntity.ok(filmsService.getAll(page));
    }

    @Operation(summary = "Get Film by ID", tags = { "Films" })
    @GetMapping("/{id}")
    public ResponseEntity<Film> getById(@PathVariable final Integer id) {
        return ResponseEntity.ok(filmsService.getById(id));
    }

}
