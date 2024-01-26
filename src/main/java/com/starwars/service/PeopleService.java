package com.starwars.service;

import com.starwars.client.PeopleRestClient;
import com.starwars.dto.ListWrapper;
import com.starwars.dto.People;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PeopleService implements BaseService<People> {

    private final PeopleRestClient client;

    public ListWrapper<People> getAll(final Integer page) {
        return client.getAll(page);
    }

    public People getById(final Integer id) {
        return client.getById(id);
    }

}