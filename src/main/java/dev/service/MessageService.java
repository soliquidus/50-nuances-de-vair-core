package dev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.entity.Message;
import dev.repository.MessageRepository;

@Service
public class MessageService {
	
	private MessageRepository messageRepository;
	
	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	public List<Message> getMessages() {
		return this.messageRepository.findAll();
	}
	
	public Message getMessage(Long id) {
		return this.messageRepository.getById(id);
	}
	
	@Transactional
	public Message addMessage(Message message) {
		return this.messageRepository.save(message);
	}
	
	@Transactional
	public void deleteMessage(Long id) {
		this.messageRepository.deleteById(id);
	}

}
