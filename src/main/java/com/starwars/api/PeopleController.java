package com.starwars.api;

import com.starwars.dto.ListWrapper;
import com.starwars.dto.People;
import com.starwars.service.PeopleService;
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
@RequestMapping("/api/v1/people")
@Tag(name = "People", description = "People API")
public class PeopleController implements BaseController<People> {

    private final PeopleService peopleService;

    @Operation(summary = "Get all People", tags = { "People" })
    @GetMapping
    public ResponseEntity<ListWrapper<People>> getAll(final Integer page) {
        return ResponseEntity.ok(peopleService.getAll(page));
    }

    @Operation(summary = "Get People by ID", tags = { "People" })
    @GetMapping("/{id}")
    public ResponseEntity<People> getById(@PathVariable final Integer id) {
        return ResponseEntity.ok(peopleService.getById(id));
    }

}
