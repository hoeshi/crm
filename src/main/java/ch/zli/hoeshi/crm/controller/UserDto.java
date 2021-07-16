package ch.zli.hoeshi.crm.controller;

import java.util.List;
import java.util.stream.Collectors;

import ch.zli.hoeshi.crm.model.AppUser;

public class UserDto {

	public Long id;
	public final String userName;
	public List<String> roles;
	public List<AutoDto> auto;

	public UserDto(AppUser user) {
		this.id = user.getId();
		this.userName = user.getUsername();
		this.roles = user.getRoles();
		this.auto = user.getAutos()
				.stream()
				.map(AutoDto::new)
				.collect(Collectors.toList());
	}

}
