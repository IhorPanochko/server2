package com.example.server2.kafka;

import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.ReceiverRecord;

@Component
public class ReactiveKafkaListener {

//    private final ReactiveKafkaConsumerTemplate<String, ProducerDTO> consumer;
//
//    public ReactiveKafkaListener(ReactiveKafkaConsumerTemplate<String, ProducerDTO> consumer) {
//        this.consumer = consumer;
//    }

    private final ReactiveKafkaProducerTemplate<String, ProducerDTO> producer;

    public ReactiveKafkaListener(ReactiveKafkaProducerTemplate<String, ProducerDTO> producer) {
        this.producer = producer;
    }


    @KafkaListener(topics = "topic1", groupId = "reactive", clientIdPrefix = "reactive")
    public void listen(@Payload ProducerDTO producerDTO) {
        ProducerDTO result = getProducerDTO(producerDTO);
        System.out.println(result);
        producer.send("topic2", result).subscribe();
    }

    private ProducerDTO getProducerDTO(ProducerDTO producerDTO) {
        String body = producerDTO.getId();
        Gson g = new Gson();
        return g.fromJson(body, ProducerDTO.class);
    }
}
