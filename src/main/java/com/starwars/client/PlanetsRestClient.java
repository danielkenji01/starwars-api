package com.starwars.client;

import com.starwars.client.config.FeignRestConfiguration;
import com.starwars.dto.ListWrapper;
import com.starwars.dto.Planet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "planetsRestClient", url = "https://swapi.dev/api/planets",
        configuration = FeignRestConfiguration.class)
public interface PlanetsRestClient extends FeignRestClient<Planet> {

    @GetMapping
    ListWrapper<Planet> getAll(@RequestParam(required = false) final Integer page);

    @GetMapping("/{id}")
    Planet getById(@PathVariable final Integer id);

}