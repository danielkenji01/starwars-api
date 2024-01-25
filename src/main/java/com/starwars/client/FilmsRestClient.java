package com.starwars.client;

import com.starwars.dto.Film;
import com.starwars.dto.ListWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "filmsRestClient", url = "https://swapi.dev/api/films")
public interface FilmsRestClient extends FeignRestClient<Film> {

    @GetMapping
    ListWrapper<Film> getAll();

    @GetMapping("/{id}")
    Film getById(@PathVariable final Integer id);

}