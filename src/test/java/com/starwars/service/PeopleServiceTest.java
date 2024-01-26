package com.starwars.service;

import java.util.Collections;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.starwars.client.PeopleRestClient;
import com.starwars.dto.ListWrapper;
import com.starwars.dto.People;
import com.starwars.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PeopleServiceTest {

    @InjectMocks
    private PeopleService peopleService;

    @Mock
    private PeopleRestClient peopleRestClient;

    @Test
    void getAll_isSuccess() {
        final People people = People.builder().build();
        final ListWrapper<People> wrapper = new ListWrapper<>(1, Collections.singletonList(people));

        when(peopleRestClient.getAll(anyInt())).thenReturn(wrapper);

        final ListWrapper<People> peopleWrapper = peopleService.getAll(anyInt());

        assertEquals(1, peopleWrapper.count());
        assertEquals(1, peopleWrapper.results().size());
    }

    @Test
    void getById_isSuccess() {
        final People peopleMock = People.builder().name("Luke Skywalker").build();

        when(peopleRestClient.getById(anyInt())).thenReturn(peopleMock);

        final People people = peopleService.getById(1);

        assertEquals("Luke Skywalker", people.name());
    }

    @Test
    void getById_whenIdNotExists_shouldThrowNotFoundException() {
        when(peopleRestClient.getById(anyInt())).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> peopleRestClient.getById(10));
    }

}