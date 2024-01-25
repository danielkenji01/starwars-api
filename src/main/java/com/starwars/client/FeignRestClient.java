package com.starwars.client;

import com.starwars.dto.ListWrapper;

public interface FeignRestClient<T> {

    ListWrapper<T> getAll();

    T getById(final Integer id);

}
