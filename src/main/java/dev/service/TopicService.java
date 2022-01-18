package dev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.entity.Topic;
import dev.repository.TopicRepository;

@Service
public class TopicService {

	private TopicRepository topicRepository;
	
	public TopicService(TopicRepository topicRepository) {
		this.topicRepository = topicRepository;
	}
	
	public List<Topic> getTopics() {
		return this.topicRepository.findAll();
	}
	
	public Topic getTopic(Long id) {
		return this.topicRepository.getById(id);
	}
	
	@Transactional
	public Topic addTopic(Topic topic) {
		return this.topicRepository.save(topic);
	}
	
	@Transactional
	public void deleteTopic(Long id) {
		this.topicRepository.deleteById(id);
	}
}
