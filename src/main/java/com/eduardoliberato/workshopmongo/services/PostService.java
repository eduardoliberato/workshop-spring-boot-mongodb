package com.eduardoliberato.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardoliberato.workshopmongo.domain.Post;
import com.eduardoliberato.workshopmongo.repository.PostRepository;
import com.eduardoliberato.workshopmongo.services.exception.ObjectNotFoundException;

@Service // to say for the spring that this is a service that can be injected to others
			// classes
public class PostService {

	@Autowired // to automatic instantiate in the service, creating the dependency injection
	private PostRepository repo;

		public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	
		public List<Post> findByTitle(String text){
			return repo.searchTitle(text); //the custom query - look in the post repository 
		}
		
		public List<Post> fullSearch(String text, Date minDate, Date maxDate){
			maxDate = new Date(maxDate.getTime() + 24 *60 *60 * 1000); //we put more one day to consider till the end of the day
			return repo.fullSearch(text, minDate, maxDate);
			
		}
	

}
