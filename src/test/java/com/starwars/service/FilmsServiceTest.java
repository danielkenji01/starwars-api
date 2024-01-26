package com.starwars.service;

import java.util.Collections;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.starwars.client.FilmsRestClient;
import com.starwars.dto.Film;
import com.starwars.dto.ListWrapper;
import com.starwars.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FilmsServiceTest {

    @InjectMocks
    private FilmsService filmsService;

    @Mock
    private FilmsRestClient filmsRestClient;

    @Test
    void getAll_isSuccess() {
        final Film film = Film.builder().build();
        final ListWrapper<Film> wrapper = new ListWrapper<>(1, Collections.singletonList(film));

        when(filmsRestClient.getAll()).thenReturn(wrapper);

        final ListWrapper<Film> filmWrapper = filmsService.getAll();

        assertEquals(1, filmWrapper.count());
        assertEquals(1, filmWrapper.results().size());
    }

    @Test
    void getById_isSuccess() {
        final Film filmMock = Film.builder().episodeId(2).build();

        when(filmsRestClient.getById(anyInt())).thenReturn(filmMock);

        final Film film = filmsService.getById(1);

        assertEquals(2, film.episodeId());
    }

    @Test
    void getById_whenIdNotExists_shouldThrowNotFoundException() {
        when(filmsRestClient.getById(anyInt())).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> filmsRestClient.getById(10));
    }

}