package com.example.server2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

//@JsonRootName("MessageDto")
public class MessageDto implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("message")
    private String message;

    public MessageDto() {
    }

    public MessageDto(String message) {
        this.message = message;
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
        return "MessageDto{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

