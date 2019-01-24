package com.xukc.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * 
 * <p>Title: UserWebSocketHandler</p>  
 * <p>Description: websocket处理类</p>  
 * @author xukuncai  
 * @date 2019年1月21日
 */
@Component
public class UserWebSocketHandler implements WebSocketHandler {
	
    private static final List<WebSocketSession> users = new ArrayList<WebSocketSession>();

    //连接已建立
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {
    	System.out.println("已建立连接。");
        users.add(session);
    }
    
    //消息接收处理
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> ws_msg)
            throws Exception {
        //消息处理
    	System.out.println("接收到服务器信息。");
    	String msg = (String) ws_msg.getPayload();
    	System.out.println(msg);
    }
    
    //连接已关闭
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
            throws Exception {
        users.remove(session);
        System.out.println("连接关闭。");
    }

    
    //异常处理
    public void handleTransportError(WebSocketSession session, Throwable e)
            throws Exception {
        if(session.isOpen()) session.close();
        users.remove(session);
        System.out.println("连接异常。");
    }
    
    public boolean supportsPartialMessages() {
        return false;
    }
    

    /**
     * @see 群发推送
     * @param message
     * @throws IOException
     */
    public void sendMessageToUsers(TextMessage message) throws IOException {
    	for (WebSocketSession user : users) {
    		if (user.isOpen()) {
    			user.sendMessage(message);
    		}
    		
    	}
    }
    
}