package com.starwars.service;

import com.starwars.client.PlanetsRestClient;
import com.starwars.dto.ListWrapper;
import com.starwars.dto.Planet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlanetsService implements BaseService<Planet> {

    private final PlanetsRestClient client;

    public ListWrapper<Planet> getAll(final Integer page) {
        return client.getAll(page);
    }

    public Planet getById(final Integer id) {
        return client.getById(id);
    }

}