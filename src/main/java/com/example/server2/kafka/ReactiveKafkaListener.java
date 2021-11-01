package com.example.server2.kafka;

import com.example.server2.dto.MessageDto;
import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ReactiveKafkaListener {

    private final ReactiveKafkaProducerTemplate<String, MessageDto> producer;

    public ReactiveKafkaListener(ReactiveKafkaProducerTemplate<String, MessageDto> producer) {
        this.producer = producer;
    }

    @KafkaListener(topics = "topic1", groupId = "reactive", clientIdPrefix = "reactive")
    public void listen(@Payload MessageDto messageDto) {
        MessageDto result = getProducerDTO(messageDto);
        producer.send("topic2", result).subscribe();
    }

    private MessageDto getProducerDTO(MessageDto producerDTO) {
        String body = producerDTO.getMessage();
        Gson g = new Gson();
        return g.fromJson(body, MessageDto.class);
    }
}
