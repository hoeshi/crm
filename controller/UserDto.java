package ch.zli3.ksh18a.crm.controller;

import ch.zli3.ksh18a.crm.model.AppUser;

public class UserDto {
	
	public long id;
	public final String userName;
	
	public UserDto(AppUser user) {
		this.id = user.getId();
		this.userName = user.getUsername();
	}
	
}
