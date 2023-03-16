package com.pavan.quotesSocial.service;

import java.util.List;

import com.pavan.quotesSocial.Enitity.User;

public interface UserService {
	
	public abstract User addUser(User user);
	public abstract List<User> getallusers();
	public abstract User updateUser(User user);
}
