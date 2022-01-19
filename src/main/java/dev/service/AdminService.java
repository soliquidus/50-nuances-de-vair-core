package dev.service;

import dev.entity.User;
import dev.repository.UserRepository;
import java.util.List;

import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.entity.Admin;
import dev.repository.AdminRepository;

@Service
public class AdminService {

	
	private final AdminRepository repository;
	private final UserRepository userRepository;

	public AdminService(AdminRepository repository, UserRepository userRepository) {
		this.repository = repository;
		this.userRepository = userRepository;
	}
	
	
public List<Admin> getAllAdmins() {
		
		return repository.findAll();
	}

	public Optional<Admin> getAdminById(Long id){
		return this.repository.findById(id);
	}
	
	@Transactional
	public Admin addAdmin(Admin admin) {
		return repository.save(admin);
	}

	@Transactional
	public void deleteAdminById(Long id) {
		repository.deleteById(id);
	}

	@Transactional
	public void updateAdmin(Long id, Admin admin){
		Optional<Admin> adminToUpdate = getAdminById(id);
		Admin forUpdate = adminToUpdate.get();
		forUpdate.setUserName(admin.getUserName());
		forUpdate.setFirstName(admin.getFirstName());
		forUpdate.setLastName(admin.getLastName());
		forUpdate.setEmail(admin.getEmail());
		forUpdate.setPassword(admin.getPassword());
		forUpdate.setActiveAccount(admin.getActiveAccount());
		forUpdate.setAddress(admin.getAddress());
		repository.save(forUpdate);
	}

	@Transactional
	public void switchAccountActivationUser (Long id){
		Optional<User> userToActivate = userRepository.findById(id);
		User forUpdate = userToActivate.get();
		if(forUpdate.getActiveAccount() == true) {
			forUpdate.setActiveAccount(false);
		} else if (forUpdate.getActiveAccount() == false){
			forUpdate.setActiveAccount(true);
		}
		userRepository.save(forUpdate);
	}
}
