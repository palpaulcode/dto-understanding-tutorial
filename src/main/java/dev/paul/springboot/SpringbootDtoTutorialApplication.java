package dev.paul.springboot;

import dev.paul.springboot.model.Location;
import dev.paul.springboot.model.User;
import dev.paul.springboot.repository.LocationRepository;
import dev.paul.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDtoTutorialApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoTutorialApplication.class, args);
	}

	private final UserRepository userRepository;
	private final LocationRepository locationRepository;

	public SpringbootDtoTutorialApplication(UserRepository userRepository,
											LocationRepository locationRepository) {
		this.userRepository = userRepository;
		this.locationRepository = locationRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Location location = new Location();
		location.setPlace("St Petersburg");
		location.setDescription("St Petersburg is  a great place to live");
		location.setLongitude(40.5);
		location.setLatitude(30.6);
		locationRepository.save(location);

		User user1 = new User();
		user1.setFirstName("Paul");
		user1.setLastName("Ryan");
		user1.setEmail("paul@ryan.com");
		user1.setPassword("secret");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2 = new User();
		user2.setFirstName("Elton");
		user2.setLastName("John");
		user2.setEmail("john@elton.com");
		user2.setPassword("s3cr3t");
		user2.setLocation(location);
		userRepository.save(user2);
	}
}
