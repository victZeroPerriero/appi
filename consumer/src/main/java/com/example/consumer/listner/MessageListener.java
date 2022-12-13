package com.example.consumer.listner;

import com.example.consumer.dto.UserDto;
import com.example.consumer.service.ServiceData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;



public class MessageListener {

    @Autowired
    private ServiceData dataService;
    @Autowired
    private ObjectMapper mapper;

    @KafkaListener(topics = "${kafka.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listener(UserDto dto) throws JsonProcessingException {
        String message = mapper.writeValueAsString(dto);
        System.out.println("Recieved message: " + message);
        dataService.save(dto);
    }
}