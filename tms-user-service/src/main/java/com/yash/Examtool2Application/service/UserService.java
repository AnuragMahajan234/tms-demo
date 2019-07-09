package com.yash.Examtool2Application.service;

import java.util.Optional;

import com.yash.Examtool2Application.domain.User;

public interface UserService {
	
	

	public User register(User user);
	
	public void delete(Integer id);
	
	public User authenticate(String loginname,String password);
	
	public User update(User user);
	
	public Iterable<User> list();
	
	public Optional<User> findByUserId(Integer id);
}
