package com.eduardoliberato.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardoliberato.workshopmongo.domain.User;
import com.eduardoliberato.workshopmongo.repository.UserRepository;
import com.eduardoliberato.workshopmongo.services.exception.ObjectNotFoundException;

@Service //to say for the spring that this is a service that can be injected to others classes 
public class UserService {
	
	@Autowired //to automatic instantiate in the service 
	private UserRepository repo;
	
	public List<User> findAll(){
		//responsible to return all the user of the data base
		return repo.findAll();
	}
	
	public User findById(String id){
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

}
