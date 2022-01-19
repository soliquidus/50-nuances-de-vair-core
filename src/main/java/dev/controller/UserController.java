package dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.User;
import dev.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping
	public List<User> getUsers(){
		return service.getAllUsers() ;
	}
	
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
		
	}
}
