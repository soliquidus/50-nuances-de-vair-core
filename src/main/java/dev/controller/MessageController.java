package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.entity.Message;
import dev.service.MessageService;

@RestController
@RequestMapping("messages")
public class MessageController {

	private MessageService messageService;
	
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@GetMapping
	public ResponseEntity<?> getMessages() {
		return ResponseEntity.ok().body(this.messageService.getMessages());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMessage(@PathVariable Long id) {
		return ResponseEntity.ok().body(this.messageService.getMessage(id));
	}
	
	@PostMapping()
	public ResponseEntity<?> addMessage(@RequestBody Message message) {
		return ResponseEntity.ok().body(this.messageService.addMessage(message));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMessage(@PathVariable Long id) {
		this.messageService.deleteMessage(id);
		return ResponseEntity.ok().body(id);
	}
	
}
