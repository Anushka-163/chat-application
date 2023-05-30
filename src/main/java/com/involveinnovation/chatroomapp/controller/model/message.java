package com.involveinnovation.chatroomapp.controller.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class message {

    private  String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;
}
