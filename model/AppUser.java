package ch.zli3.ksh18a.crm.model;

import org.springframework.security.core.userdetails.UserDetails;

public interface AppUser extends UserDetails {
	Long getId();
}
