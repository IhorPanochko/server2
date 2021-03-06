package com.example.server2.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

//@JsonRootName("FakeProducer")
public class ProducerDTO implements Serializable{
    @JsonProperty("id")
    private String id;

    @JsonProperty("message")
    private String message;


    public ProducerDTO() {
    }

    public ProducerDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ProducerDTO{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
