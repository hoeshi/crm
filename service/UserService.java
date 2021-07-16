package ch.zli3.ksh18a.crm.service;

import java.util.List;

import ch.zli3.ksh18a.crm.model.AppUser;

public interface UserService {
	
	List<AppUser> getAllUsers();
	
	AppUser addUser(String userName, String password);
	
	AppUser findByUserName(String userName);

	AppUser getUserById(long userId);
	
	AppUser getUserByUsername(String username);

	void deleteUserById(long userId);
}
