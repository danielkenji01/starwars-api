package com.starwars.service;

import com.starwars.client.FilmsRestClient;
import com.starwars.dto.Film;
import com.starwars.dto.FilmWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilmsService {

    private final FilmsRestClient client;

    public FilmWrapper getAll() {
        return client.getAll();
    }

    public Film getById(final Integer id) {
        return client.getById(id);
    }

}