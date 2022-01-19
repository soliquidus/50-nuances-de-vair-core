package dev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.entity.User;
import dev.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;
	

	public UserService(UserRepository repository) {
		this.repository = repository;
	}


	
	
	public List<User> getAllUsers() {
		
		return (List<User>) repository.findAll();
	}
	
	
	@Transactional
	public User addUser(User user) {
		
		return repository.save(user);
	}
	
}
