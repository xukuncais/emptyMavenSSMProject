package com.xukc.websocket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * 
 * <p>Title: UserWebSocketHandshakeInterceptor</p>  
 * <p>Description:websocket连接握手拦截器 类</p>  
 * @author xukuncai  
 * @date 2019年1月21日
 */
public class UserWebSocketHandshakeInterceptor implements HandshakeInterceptor {

	//握手前
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	//握手后
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		// TODO Auto-generated method stub
		
	}
}
