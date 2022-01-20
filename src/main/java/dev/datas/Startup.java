package dev.datas;

import java.util.stream.IntStream;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.entity.Address;
import dev.entity.User;
import dev.repository.UserRepository;

@Component
public class Startup {

	private UserRepository userRepository;
	
	public Startup(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void onStartup() {
		
		if (this.userRepository.count() == 0) {
			IntStream.of(1, 2, 3, 4, 5).mapToObj(i -> new User("username" + i, "prenom-" + i, "nom-" + i, "email@email-" + i + ".fr", "password" + i, true, null, new Address("street-" + i, "number-" + i, "complement-" + i), null))
					.forEach(userRepository::save);
		}
	}
}
