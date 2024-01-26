package com.starwars.dto;

import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record People(String name, String height, String mass, @JsonProperty("hair_color") String hairColor,
                     @JsonProperty("skin_color") String skinColor, @JsonProperty("eye_color") String eyeColor,
                     @JsonProperty("birth_year") String birthYear, String gender, String homeworld,
                     List<String> films, List<String> species, List<String> vehicles, List<String> starships,
                     Date created, Date edited, String url) {

}