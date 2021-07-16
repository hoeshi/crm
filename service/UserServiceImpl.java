package ch.zli3.ksh18a.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli3.ksh18a.crm.exceptions.EmptyParameterException;
import ch.zli3.ksh18a.crm.exceptions.UsernameTakenException;
import ch.zli3.ksh18a.crm.model.AppUser;
import ch.zli3.ksh18a.crm.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AppUser> getAllUsers() {

        List<AppUser> users = new ArrayList<>();
        for (AppUser user :
                userRepository.findAll()) {
            users.add(user);
        }

        return users;
    }

    @Override
    public AppUser addUser(String username, String password) {
        // Check for empty arguments
        if (username == null || password == null) {
            throw new EmptyParameterException();
        }
        // Check unique username
        if (userRepository.findByuserName(username).isPresent()) {
            throw new UsernameTakenException();
        }
        return userRepository.addUser(username, password);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        // Check for empty arguments
        if (username == null) {
            throw new RuntimeException("Invalid arguments");
        }
        return userRepository.findByuserName(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

	@Override
	public AppUser findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser getUserById(long userId) {
		return userRepository.findById(userId)
			.orElseThrow(RuntimeException::new);
	}
	
	@Override
	public void deleteUserById(long userId) {
		getUserById(userId);
		userRepository.deleteById(userId);
	}

}