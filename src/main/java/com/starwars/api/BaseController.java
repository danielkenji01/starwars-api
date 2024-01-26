package com.starwars.api;

import com.starwars.dto.ListWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface BaseController<T> {

    ResponseEntity<ListWrapper<T>> getAll(@RequestParam(required = false, defaultValue = "1") final Integer page);

    ResponseEntity<T> getById(final Integer id);

}
