package com.app.chatApp.controller;

import com.app.chatApp.model.ChatMessage;
import com.app.chatApp.Repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class chatController {

    @Autowired
     private ChatRepository chatRepository;
        @MessageMapping("/sendMessage")
        @SendTo("/topic/messages")
        public ChatMessage sendMessage(ChatMessage message){
            chatRepository.save(message);
            return message;
        }
        @GetMapping("/chat")
        public String chat(){
            return "chat";
        }
}
