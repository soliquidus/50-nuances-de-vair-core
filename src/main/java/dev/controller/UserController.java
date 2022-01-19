package dev.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		Optional<User> optUser = this.service.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(optUser.get());
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}



	@PutMapping("update/{id}")
	public void updateUser(@PathVariable Long id, @RequestBody User user) {
		Optional<User> userToUpdate = service.getUserById(id);
		if(userToUpdate.isPresent()) {
			service.updateUser(id, user);
		} else {
			service.addUser(user);
		}
	}

}
