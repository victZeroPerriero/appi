package com.example.producer.service;


import com.example.producer.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.http.HttpHeaders;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WebClientServiceImpl {
    private final WebClient webClient;

    public Mono<UserDto> someRestCall(Integer id) {
        return this.webClient.get().uri("{id}",id)
                .retrieve().bodyToMono(UserDto.class);
    }


    public Flux<UserDto> getAllUSers(){
        return webClient.get().uri("")
                .header(org.springframework.http.HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(UserDto.class);
    }
}
