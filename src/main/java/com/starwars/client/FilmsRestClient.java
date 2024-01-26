package com.starwars.client;

import com.starwars.client.config.FeignRestConfiguration;
import com.starwars.dto.Film;
import com.starwars.dto.ListWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "filmsRestClient", url = "https://swapi.dev/api/films",
        configuration = FeignRestConfiguration.class)
public interface FilmsRestClient extends FeignRestClient<Film> {

    @GetMapping
    ListWrapper<Film> getAll(@RequestParam(required = false) final Integer page);

    @GetMapping("/{id}")
    Film getById(@PathVariable final Integer id);

}