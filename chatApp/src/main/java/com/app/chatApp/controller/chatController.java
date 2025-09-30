package com.app.chatApp.controller;

import com.app.chatApp.model.chatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class chatController {
        @MessageMapping("/sendMessage")
        @SendTo("/topic/messages")
        public chatMessage sendMessage(chatMessage message){
            return message;
        }
}
