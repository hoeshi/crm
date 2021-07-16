package ch.zli.hoeshi.crm.model;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity(name = "User")
@SuppressWarnings("serial")
public class AppUserImpl implements AppUser {

	@Id
	@GeneratedValue
	private Long id;
	private String userName;
	private String passwordHash;
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	// For simple types only, no Role objects allowed
	private Set<String> roles;
	
	@OneToMany(mappedBy = "mieter", cascade = CascadeType.DETACH)
	private List<AutoImpl> gemieteteAutos;
	
	protected AppUserImpl() {} // For JPA only
	
	public AppUserImpl(String userName, String password, List<String> roles) {
		this.userName = userName;
		setPassword(password);
		this.roles = new HashSet<>(roles);

	}

	public AppUserImpl setRoles(List<String> roles) {
		this.roles = new HashSet<>(roles);
		return this;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream()
			.map(role -> new SimpleGrantedAuthority(role))
			.collect(Collectors.toList());
	}
	
	@Override 
	public List<String> getRoles() {
		return new ArrayList<>(roles);
	}

	@Override public Long getId()         { return id; }
	@Override public String getPassword() { return passwordHash; }
	@Override public String getUsername() { return userName; }

	@Override public boolean isAccountNonExpired()     { return true; }
	@Override public boolean isAccountNonLocked()      { return true; }
	@Override public boolean isCredentialsNonExpired() { return true; }
	@Override public boolean isEnabled()               { return true; }

	private void setPassword(String password) {
		BCryptPasswordEncoder pwe = new BCryptPasswordEncoder();
		passwordHash = pwe.encode(password);
	}

	@Override
	public List<Auto> getAutos() {
		return gemieteteAutos.stream().collect(Collectors.toList());
	}
}
