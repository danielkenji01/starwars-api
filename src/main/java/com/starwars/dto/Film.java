package com.starwars.dto;

import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record Film(String title, @JsonProperty("episode_id") Integer episodeId,
                   @JsonProperty("opening_crawl") String openingCrawl, String director, String producer,
                   @JsonProperty("release_date") Date releaseDate, List<String> characters, List<String> planets,
                   List<String> starships, List<String> vehicles, List<String> species, Date created, Date edited,
                   String url) {

}