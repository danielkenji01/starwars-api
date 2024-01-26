package com.starwars.dto;

import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record Planet(String name, @JsonProperty("rotation_period") String rotationPeriod,
                     @JsonProperty("orbital_period") String orbitalPeriod, String diameter,
                     String climate, String gravity, String terrain,
                     @JsonProperty("surface_water") String surfaceWater, String population,
                     List<String> residents, List<String> films, Date created, Date edited, String url) {
}
