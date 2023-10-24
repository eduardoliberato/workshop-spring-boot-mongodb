package com.eduardoliberato.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.eduardoliberato.workshopmongo.domain.Post;
import com.eduardoliberato.workshopmongo.domain.User;
import com.eduardoliberato.workshopmongo.repository.PostRepository;
import com.eduardoliberato.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired //automatic dependency injection - to be possible use the database (save, delete, update) - 
	private UserRepository userRepository;
	
	@Autowired //automatic dependency injection - to be possible use the database (save, delete, update) -
	private PostRepository postRepository;

	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll(); //to clean the data base
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@email.com");
		User alex = new User(null, "Alex Green", "alex@email.com");
		User bob = new User(null, "Bob Grey", "bob@email.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia",  "Acordei feliz hoje!", maria);

		userRepository.saveAll(Arrays.asList(maria, alex, bob)); //to save the new instantiation
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
