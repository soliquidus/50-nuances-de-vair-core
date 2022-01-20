package dev.service;

import java.util.List;

import java.util.Optional;
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
		
		return repository.findAll();
	}
	
	
	@Transactional
	public User addUser(User user) {
		
		return repository.save(user);
	}

	public Optional<User> getUserById(Long id){
		return this.repository.findById(id);
	}

	@Transactional
	public void deleteUserById(Long id) {

		repository.deleteById(id);
	}

	@Transactional
	public void updateUser(Long id, User user){
		Optional<User> userToUpdate = getUserById(id);
		User forUpdate = userToUpdate.get();
		forUpdate.setUserName(user.getUserName());
		forUpdate.setFirstName(user.getFirstName());
		forUpdate.setLastName(user.getLastName());
		forUpdate.setEmail(user.getEmail());
		forUpdate.setPassword(user.getPassword());
		forUpdate.setActiveAccount(user.getActiveAccount());
		forUpdate.setAddress(user.getAddress());
		repository.save(forUpdate);
	}



}
