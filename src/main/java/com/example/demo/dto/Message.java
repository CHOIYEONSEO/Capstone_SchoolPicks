package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Message {
    String message = "";

    public Message(String message) {
        this.message = message;
    }
}
