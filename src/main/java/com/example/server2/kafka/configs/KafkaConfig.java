package com.example.server2.kafka.configs;


import com.example.server2.dto.MessageDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.sender.SenderOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {

    private final String kafkaAddress = "0.0.0.0:9092";

    private final String kafkaTopic = "reactive-test-topic";

    private final String kafkaGroupId = "reactive";

    private final String kafkaClientId = "reactive";

    @Bean
    public ReactiveKafkaConsumerTemplate<String, MessageDto> reactiveKafkaConsumerTemplate() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaGroupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        props.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);

        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "com.example.server2.dto.MessageDto");

        ReceiverOptions<String, MessageDto> opts =
                ReceiverOptions.<String, MessageDto>create(props)
                        .subscription(Collections.singleton(kafkaTopic));

        return new ReactiveKafkaConsumerTemplate<>(opts);
    }

    @Bean
    public ReactiveKafkaProducerTemplate<String, MessageDto> reactiveKafkaProducerTemplate() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaClientId);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        SenderOptions<String, MessageDto> opts = SenderOptions.create(props);
        return new ReactiveKafkaProducerTemplate<>(opts);
    }
}
