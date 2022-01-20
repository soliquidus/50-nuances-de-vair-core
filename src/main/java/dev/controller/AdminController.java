package dev.controller;

import dev.entity.User;
import dev.service.UserService;
import java.util.List;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Admin;
import dev.service.AdminService;

@RestController
@RequestMapping("admins")
public class AdminController {
	
	private AdminService service;
	private UserService userService;

	public AdminController(AdminService service, UserService userService) {
		this.service = service;
		this.userService = userService;
	}

	@GetMapping
	public List<Admin> getAdmins(){
		return service.getAllAdmins() ;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAdmin(@PathVariable Long id) {
		Optional<Admin> optAdmin = this.service.getAdminById(id);
		return ResponseEntity.status(HttpStatus.OK).body(optAdmin.get());
	}

	@PostMapping("/add")
	public Admin addAdmin(@RequestBody Admin admin) {
		admin.setIsAdmin(true);
		return service.addAdmin(admin);
	}

	@DeleteMapping("/delete/admin/{id}")
	public void deleteAdmin(@PathVariable Long id) {
		service.deleteAdminById(id);
	}

	@DeleteMapping("/delete/user/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
	}

	@PutMapping("update/{id}")
	public void updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
		Optional<Admin> adminToUpdate = service.getAdminById(id);
		if(adminToUpdate.isPresent()) {
			service.updateAdmin(id, admin);
		} else {
			service.addAdmin(admin);
		}
	}

	@PutMapping("suspend/user/{id}")
	public void switchAccountActivationUser(@PathVariable Long id) {
		Optional<User> userToUpdate = userService.getUserById(id);
		if(userToUpdate.isPresent()) {
			service.switchAccountActivationUser(id);
		}
	}

}
