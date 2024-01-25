package com.starwars.dto;

import java.util.List;

public record ListWrapper<T>(Integer count, List<T> results) {
}
