package com.starwars.client.config;

import com.starwars.exception.BadRequestException;
import com.starwars.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ErrorMessageDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(final String methodKey, final Response response) {
        return switch (response.status()) {
            case 400 -> new BadRequestException("Bad request");
            case 404 -> new NotFoundException("Not found");
            default -> errorDecoder.decode(methodKey, response);
        };
    }

}