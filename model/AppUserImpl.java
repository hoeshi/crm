package ch.zli3.ksh18a.crm.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("serial")
@Entity(name = "User")
public class AppUserImpl implements AppUser{

	public AppUserImpl(String userName, String password) {
		this.userName = userName;
		setPassword(password);
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String userName;

	private String passwordHash;
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	protected AppUserImpl() {} //For JPA only

	private void setPassword(String password) {
		BCryptPasswordEncoder pwe = new BCryptPasswordEncoder();
		passwordHash = pwe.encode(password);
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return passwordHash;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true	;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	

}
