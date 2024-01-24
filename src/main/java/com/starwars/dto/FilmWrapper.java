package com.starwars.dto;

import java.util.List;

public record FilmWrapper(Integer count, List<Film> results) {
}
