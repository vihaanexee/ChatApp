package com.app.chatApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //directs messages to the correct way decides where the message goes
public class webSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat") // point to access the api .... point of entry in the application
                .setAllowedOrigins("http://localhost:8090") //allow reqs from this origin only, security feature
                .withSockJS(); // compatibility for clients that dont support websockets by using sockjs
        

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");  // a channel where everyone is /topic can access the chat whoever sends it in topic
        registry.setApplicationDestinationPrefixes("/app");
        //expect message with /app/sendmessage
    }
}
