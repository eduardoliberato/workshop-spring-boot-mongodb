package com.eduardoliberato.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.eduardoliberato.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	/*with that you can do a lot of standards commands
	 * as save, update, dele, all because of the MongoRepository< type , ID type> 
	 */
	
	
	//this is a custom query 
	//'title' is the field we want to do the search
	//?0 - indicates that is the first parameter in the properties of the search, in this case the string text
	//the 'i' in the options indicate that is "Case insensitivity to match upper and lower cases", for learn more about the possible options is necessary to search in the mongodb manual
	@Query("{ 'title' : { $regex: ?0 , $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	
	//the logic for "findByTitleContainingIgnoreCase" is already done, as this is a query
	
	List<Post> findByTitleContainingIgnoreCase(String text); //this do that the spring data create the search - ignoring the case of the letters

}
