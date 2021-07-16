package ch.zli3.ksh18a.crm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ch.zli3.ksh18a.crm.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
		throws UsernameNotFoundException
	{
		return userRepository.findByuserName(username)
				.orElseThrow(
						() -> {
							throw new UsernameNotFoundException(username + " not found");
							}
						);
	}


}