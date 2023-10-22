package com.eduardoliberato.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardoliberato.workshopmongo.domain.User;
import com.eduardoliberato.workshopmongo.dto.UserDTO;
import com.eduardoliberato.workshopmongo.repository.UserRepository;
import com.eduardoliberato.workshopmongo.services.exception.ObjectNotFoundException;

@Service //to say for the spring that this is a service that can be injected to others classes 
public class UserService {
	
	@Autowired //to automatic instantiate in the service, creating the dependency injection 
	private UserRepository repo;
	
	public List<User> findAll(){
		//responsible to return all the user of the data base
		return repo.findAll();
	}
	
	public User findById(String id){
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id); //to reuse the exception of this function 
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
