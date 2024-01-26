package com.starwars.client;

import com.starwars.client.config.FeignRestConfiguration;
import com.starwars.dto.ListWrapper;
import com.starwars.dto.People;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "peopleRestClient", url = "https://swapi.dev/api/people",
        configuration = FeignRestConfiguration.class)
public interface PeopleRestClient extends FeignRestClient<People> {

    @GetMapping
    ListWrapper<People> getAll(@RequestParam(required = false) Integer page);

    @GetMapping("/{id}")
    People getById(@PathVariable final Integer id);

}