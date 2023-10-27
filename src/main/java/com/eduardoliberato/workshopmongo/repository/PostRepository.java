package com.eduardoliberato.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eduardoliberato.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	/*with that you can do a lot of standards commands
	 * as save, update, dele, all because of the MongoRepository< type , ID type> 
	 */
	
	//the logic for "findByTitleContainingIgnoreCase" is already done, as this is a query
	
	List<Post> findByTitleContainingIgnoreCase(String text); //this do that the spring data create the search - ignoring the case of the letters

}
