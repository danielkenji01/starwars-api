package com.starwars.service;

import java.util.Collections;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.starwars.client.PlanetsRestClient;
import com.starwars.dto.ListWrapper;
import com.starwars.dto.Planet;
import com.starwars.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PlanetsServiceTest {

    @InjectMocks
    private PlanetsService planetsService;

    @Mock
    private PlanetsRestClient planetsRestClient;

    @Test
    void getAll_isSuccess() {
        final Planet planet = Planet.builder().build();
        final ListWrapper<Planet> wrapper = new ListWrapper<>(1, Collections.singletonList(planet));

        when(planetsRestClient.getAll(anyInt())).thenReturn(wrapper);

        final ListWrapper<Planet> planetWrapper = planetsService.getAll(anyInt());

        assertEquals(1, planetWrapper.count());
        assertEquals(1, planetWrapper.results().size());
    }

    @Test
    void getById_isSuccess() {
        final Planet planetMock = Planet.builder().name("Eriadu").build();

        when(planetsRestClient.getById(anyInt())).thenReturn(planetMock);

        final Planet planet = planetsService.getById(1);

        assertEquals("Eriadu", planet.name());
    }

    @Test
    void getById_whenIdNotExists_shouldThrowNotFoundException() {
        when(planetsRestClient.getById(anyInt())).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> planetsRestClient.getById(10));
    }

}