package com.starwars.service;

import com.starwars.client.FilmsRestClient;
import com.starwars.dto.Film;
import com.starwars.dto.ListWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilmsService implements BaseService<Film> {

    private final FilmsRestClient client;

    public ListWrapper<Film> getAll(final Integer page) {
        return client.getAll(page);
    }

    public Film getById(final Integer id) {
        return client.getById(id);
    }

}