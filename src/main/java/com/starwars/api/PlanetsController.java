package com.starwars.api;

import com.starwars.dto.ListWrapper;
import com.starwars.dto.Planet;
import com.starwars.service.PlanetsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/planets")
@Tag(name = "Planets", description = "Planets API")
public class PlanetsController implements BaseController<Planet> {

    private final PlanetsService planetsService;

    @Operation(summary = "Get all Planet", tags = { "Planets" })
    @GetMapping
    public ResponseEntity<ListWrapper<Planet>> getAll(final Integer page) {
        return ResponseEntity.ok(planetsService.getAll(page));
    }

    @Operation(summary = "Get Planet by ID", tags = { "Planets" })
    @GetMapping("/{id}")
    public ResponseEntity<Planet> getById(@PathVariable final Integer id) {
        return ResponseEntity.ok(planetsService.getById(id));
    }

}
