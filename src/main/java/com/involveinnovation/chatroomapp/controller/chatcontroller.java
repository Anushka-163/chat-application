package com.involveinnovation.chatroomapp.controller;

import com.involveinnovation.chatroomapp.controller.model.message;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class chatcontroller {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/msg")
    @SendTo("/chatroom/public")

    private message receivePublicMessage(@Payload message msg){

        return msg;
    }
    @MessageMapping("/private-message")
    public message receivedPrivateMessage(@Payload message msg){

        simpMessagingTemplate.convertAndSendToUser(msg.getReceiverName(),"/private",msg);
        return msg;
    }
}
