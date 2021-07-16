package ch.zli.hoeshi.crm.model;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

public interface AppUser extends UserDetails {
	public Long getId();
	public List<String> getRoles();
	public List<Auto> getAutos();
}
