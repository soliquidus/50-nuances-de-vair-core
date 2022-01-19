package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Topic;
import dev.service.TopicService;

@RestController
@RequestMapping("topics")
public class TopicController {

	private TopicService topicService;
	
	public TopicController(TopicService topicService) {
		this.topicService = topicService;
	}
	
	@GetMapping
	public ResponseEntity<?> getTopics() {
		return ResponseEntity.ok().body(this.topicService.getTopics());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getTopic(@PathVariable Long id) {
		return ResponseEntity.ok().body(this.topicService.getTopic(id));
	}
	
	@PostMapping()
	public ResponseEntity<?> addTopic(@RequestBody Topic Topic) {
		return ResponseEntity.ok().body(this.topicService.addTopic(Topic));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
		this.topicService.deleteTopic(id);
		return ResponseEntity.ok().body(id);
	}
	
}
