package dev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.entity.Admin;
import dev.repository.AdminRepository;

@Service
public class AdminService {

	
	private final AdminRepository repository;

	public AdminService(AdminRepository repository) {
		this.repository = repository;
	}
	
	
public List<Admin> getAllAdmins() {
		
		return (List<Admin>) repository.findAll();
	}
	
	
	@Transactional
	public Admin addAdmin(Admin admin) {
		
		return repository.save(admin);
	}
	
	
}
