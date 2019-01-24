package com.xukc.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xukc.entity.User;
import com.xukc.service.UserService;



@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	UserService userService;

    @RequestMapping("/list")
    public String gotoIndexPage(HttpServletRequest request) throws Exception{
    	logger.info("进入请求");
    	User user = userService.selectUserById(1L);
    	
    	request.setAttribute("user", user);
    	return "index";
    }  
      
}
