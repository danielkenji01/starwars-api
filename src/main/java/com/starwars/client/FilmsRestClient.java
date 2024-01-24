package com.starwars.client;

import com.starwars.dto.FilmWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "filmsRestClient", url = "https://swapi.dev/api/films")
public interface FilmsRestClient {

    @GetMapping
    FilmWrapper getAll();

}
