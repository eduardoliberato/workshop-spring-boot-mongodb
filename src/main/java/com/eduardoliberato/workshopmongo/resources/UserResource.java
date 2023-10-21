package com.eduardoliberato.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eduardoliberato.workshopmongo.domain.User;
import com.eduardoliberato.workshopmongo.services.UserService;

@RestController //to say that this is a rest resource
@RequestMapping(value="/users") //to set the path of the end point, the text between the " " is the path, you find the information in this "place"
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){	
		
		List<User> list = service.findAll(); //that way you search the user in the data base and save in this list
		return ResponseEntity.ok().body(list); //answer HTTP 
		
	}

}
