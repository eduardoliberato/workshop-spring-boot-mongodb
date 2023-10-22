package com.eduardoliberato.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eduardoliberato.workshopmongo.domain.User;
import com.eduardoliberato.workshopmongo.dto.UserDTO;
import com.eduardoliberato.workshopmongo.services.UserService;

@RestController //to say that this is a rest resource
@RequestMapping(value="/users") //to set the path of the end point, the text between the " " is the path, you find the information in this "place"
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){	
		
		List<User> list = service.findAll(); //that way you search the user in the data base and save in this list
		//is necessary to convert the list of users for a list of userDTO , them convert this again for a list, as below:
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto); //answer HTTP 
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable /*to say this id is the same received in the URL*/ String id){	
		
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(obj) /*to convert to userdto*/); //answer HTTP 
		
	}

}
