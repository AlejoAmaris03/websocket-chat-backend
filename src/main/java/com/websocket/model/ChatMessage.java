package com.websocket.model;

import com.websocket.utils.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChatMessage {
    private MessageType type;
    private String sender;
    private String message;
}
