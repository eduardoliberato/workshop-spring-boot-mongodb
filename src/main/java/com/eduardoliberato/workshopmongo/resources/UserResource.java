package com.eduardoliberato.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eduardoliberato.workshopmongo.domain.User;

@RestController //to say that this is a rest resource
@RequestMapping(value="/users") //to set the path of the end point, the text between the " " is the path, you find the information in this "place"
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		
		User maria = new User("1", "Maria Brown", "maria@mail.com");
		User alex = new User("2", "Alex Green", "alexa@mail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list); //answer HTTP 
		
	}

}
