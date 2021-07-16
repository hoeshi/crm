package ch.zli3.ksh18a.crm.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli3.ksh18a.crm.model.AppUser;
import ch.zli3.ksh18a.crm.service.UserService;

@RestController()
@RequestMapping("rest/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    List<UserDto> getAllUsers() {
        // For each User map User fields to UserDto
        return userService.getAllUsers() // List<User>
                .stream() // -> stream
                .map(UserDto::new) // -> map
                .collect(Collectors.toList()); // -> List<UserDto>
    }

    @PostMapping("")
    UserDto addUser(@RequestBody UserInputDto userInput) {
        AppUser user = userService.addUser(userInput.getUsername(), userInput.getPassword());
        return new UserDto(user);
    }

    @GetMapping("{id}")
    UserDto getUser(@PathVariable("id") Long userId) {
        AppUser user = userService.getUserById(userId);
        return new UserDto(user);
    }

}
