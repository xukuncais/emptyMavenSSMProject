package com.xukc.task;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import com.xukc.controller.UserController;
import com.xukc.entity.User;
import com.xukc.service.UserService;
import com.xukc.websocket.UserWebSocketHandler;


@Service
public class UserTask {
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserWebSocketHandler userWebSocketHandler;
	@Autowired
	private UserService userService;
	
	@Scheduled(cron="0 0/1 * * * ?")
	public void pushData2Charts() throws Exception {
		logger.info("-------定时任务执行开始--------");
		
		User user = userService.selectUserById(1L);
		
		TextMessage message = new TextMessage(user.getUserName()); 
		userWebSocketHandler.sendMessageToUsers(message);
		
		logger.info("-------定时任务执行结束--------");
	}
	
}

