package com.starwars.service;

import com.starwars.dto.ListWrapper;

public interface BaseService<T> {

    ListWrapper<T> getAll(final Integer page);

    T getById(final Integer id);

}
