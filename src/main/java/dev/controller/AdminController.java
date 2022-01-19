package dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Admin;
import dev.service.AdminService;

@RestController
@RequestMapping("admins")
public class AdminController {
	
	private AdminService service;

	public AdminController(AdminService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Admin> getAdmins(){
		return service.getAllAdmins() ;
	}
	
	
	@PostMapping("/add")
	public Admin addAdmin(@RequestBody Admin admin) {
		return service.addAdmin(admin);
		
	}

}
