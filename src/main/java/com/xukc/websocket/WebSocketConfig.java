package com.xukc.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * 
 * <p>Title: WebSocketConfig</p>  
 * <p>Description: websocket配置类</p>  
 * @author xukuncai  
 * @date 2019年1月21日
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new UserWebSocketHandler(),"/echartsWebSocket").addInterceptors(new UserWebSocketHandshakeInterceptor());
        registry.addHandler(new UserWebSocketHandler(), "/sockjs/echartsWebSocket").addInterceptors(new UserWebSocketHandshakeInterceptor()).withSockJS();
    }
}