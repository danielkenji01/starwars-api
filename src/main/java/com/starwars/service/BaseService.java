package com.starwars.service;

public interface BaseService<T> {

    T getById(final Integer id);

}
