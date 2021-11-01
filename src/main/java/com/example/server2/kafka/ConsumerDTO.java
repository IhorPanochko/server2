package com.example.server2.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

@JsonRootName("FakeConsumer")
public class ConsumerDTO implements Serializable {

    @JsonProperty("id")
    private String id;

    public ConsumerDTO() {
    }

    public ConsumerDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ConsumerDTO{" +
                "id='" + id + '\'' +
                '}';
    }
}
