package com.starwars.client.config;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class FeignRestConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorMessageDecoder();
    }

}
