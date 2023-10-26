package com.eduardoliberato.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eduardoliberato.workshopmongo.domain.Post;
import com.eduardoliberato.workshopmongo.domain.User;
import com.eduardoliberato.workshopmongo.services.PostService;

@RestController //to say that this is a rest resource
@RequestMapping(value="/posts") //to set the path of the end point, the text between the " " is the path, you find the information in this "place"
public class PostResource {
	
	@Autowired
	private PostService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable /*to say this id is the same received in the URL*/ String id){	
		
		Post obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj); 
	}
	
	

}
