/**
 * 
 */
package com.xukc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xukc.entity.User;
import com.xukc.mapper.UserMapper;

/**  
 * <p>Title: UserService</p>  
 * <p>Description: </p>  
 * @author xukuncai  
 * @date 2019年1月22日  
*/
@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	public User selectUserById(Long userId) throws Exception{
		User user = userMapper.selectUserById(1L);
		return user;
	}
	public List<User> selectUserList() throws Exception{
		List<User> list = userMapper.selectUserList();
		return list;
	}
	

}
