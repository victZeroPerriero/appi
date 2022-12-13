package com.example.producer;

import com.example.producer.dto.UserDto;
import com.example.producer.service.ServeceSendMessage;
import com.example.producer.service.WebClientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
    @Bean
    public CommandLineRunner get(WebClientServiceImpl webClientService, ServeceSendMessage serveceSendMessage){
        return args -> {
          log.info("start application........");
        Flux<UserDto> userDtoList  = webClientService.getAllUSers();
          Mono<UserDto> userDtoMono =  webClientService.someRestCall(2);
        log.info("reciev data about all users is remote rest api {}",userDtoList.buffer().blockFirst());
        log.info("resiev one user{}", userDtoMono.block());
         UserDto dto = userDtoMono.block();
         serveceSendMessage.sendMessage(dto);

        };
    }

}
