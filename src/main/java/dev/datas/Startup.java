package dev.datas;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.entity.Address;
import dev.entity.Admin;
import dev.entity.Message;
import dev.entity.User;
import dev.entity.Rubric;
import dev.entity.Topic;
import dev.repository.AdminRepository;
import dev.repository.MessageRepository;
import dev.repository.RubricRepository;
import dev.repository.TopicRepository;
import dev.repository.UserRepository;

@Component
public class Startup {
	
	private AdminRepository adminRepository;
	private UserRepository userRepository;
	private RubricRepository rubricRepository;
	private TopicRepository topicRepository;
	private MessageRepository messageRepository;	 
	
	public Startup(AdminRepository adminRepository, UserRepository userRepository, RubricRepository rubricRepository, TopicRepository topicRepository, MessageRepository messageRepository) {
		this.adminRepository = adminRepository;
		this.userRepository = userRepository;
		this.rubricRepository = rubricRepository;
		this.topicRepository = topicRepository;
		this.messageRepository = messageRepository;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void onStartup() {
		
		if ((this.adminRepository.count() == 0) && (this.userRepository.count() == 0) && (this.rubricRepository.count() == 0) && (this.topicRepository.count() == 0)) {
			
			Admin admin = new Admin("admin", "prenom", "nom", "email@email.fr", "password-admin", true, true, false, false, null, new Address("street", "number", "complement"), null, null);
			adminRepository.save(admin);

			IntStream.of(1, 2, 3, 4, 5).mapToObj(i -> new User("username" + i, "prenom-" + i, "nom-" + i, "email@email-" + i + ".fr", "password" + i, true, false, true, false, null, new Address("street-" + i, "number-" + i, "complement-" + i), null))
					.forEach(userRepository::save);

			IntStream.of(1, 2, 3).mapToObj(i -> new Rubric("Rubric-" + i, admin, null, null))
					.forEach(rubricRepository::save);
			
			for (int i=0; i<5;i++) {
				Long id_user = this.getRandomNumber(1, 5);
				Long id_rubric = this.getRandomNumber(1, 3);
				Topic topic = new Topic("Topic-" + i, LocalDateTime.now(), userRepository.getById(id_user), null, rubricRepository.getById(id_rubric));
				topicRepository.save(topic);
			}
			
			for (int i=0; i<5;i++) {
				Long id_user = this.getRandomNumber(1, 5);
				Long id_topic = this.getRandomNumber(1, 5);
				Message message = new Message("Message blabla -" + i, LocalDateTime.now(), userRepository.getById(id_user), topicRepository.getById(id_topic));
				messageRepository.save(message);
			}
		}

	}
	
	public Long getRandomNumber(int min, int max) {
		long leftLimit = min;
	    long rightLimit = max;
	    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	    return generatedLong;
	}
}
