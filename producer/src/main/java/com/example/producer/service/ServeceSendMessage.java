package com.example.producer.service;

import com.example.producer.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@NoArgsConstructor
@Slf4j
public class ServeceSendMessage {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    @Autowired
    private ObjectMapper mapper;
    @Value("${kafka.topic.name}")
    private String topicName;

    public void sendMessage(UserDto dto) throws JsonProcessingException {
       String message = mapper.writeValueAsString(dto);

        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Unable to send message = {} dut to: {}", message, throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringDataSendResult) {
                log.info("Sent Message = {} with offset = {}",message, stringDataSendResult.getRecordMetadata().offset());
            }
        });
    }
}
