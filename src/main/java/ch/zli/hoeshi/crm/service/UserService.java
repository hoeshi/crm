package ch.zli.hoeshi.crm.service;

import java.util.List;

import ch.zli.hoeshi.crm.model.AppUser;



public interface UserService {

	List<AppUser> getAllUsers();

	AppUser addUser(String userName, String password, List<String> roles);
	
	AppUser findByUserName(String userName);

	AppUser getUserById(long userId);

	void deleteUserById(long userId);

	AppUser setRolesForUser(long userId, List<String> roles);

}
