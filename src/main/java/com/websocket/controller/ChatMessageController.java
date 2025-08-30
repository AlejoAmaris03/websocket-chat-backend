package com.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import com.websocket.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j

public class ChatMessageController {
    @MessageMapping("/sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage message) {
        log.info("Message received from user: {}", message.getSender());
        return message;
    }

    @SuppressWarnings("null")
    @MessageMapping("/addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        log.info("User added: {}", message.getSender());
        return message;
    }
}
