package com.eduardoliberato.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eduardoliberato.workshopmongo.domain.Post;
import com.eduardoliberato.workshopmongo.resources.util.URL;
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
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text){	
		
		//to decode:
		text = URL.decodeParam(text);
		
		List<Post> list = service.findByTitle(text);
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> fullsearch(
			@RequestParam(value="text", defaultValue="") String text,
			@RequestParam(value="minDate", defaultValue="") String minDate,
			@RequestParam(value="maxDate", defaultValue="") String maxDate){	
		
		//to decode:
		text = URL.decodeParam(text);
		
		Date min = URL.convertDate(minDate,new Date(0L)); // 0L is the first date of the system 
		Date max = URL.convertDate(maxDate,new Date());
		List<Post> list = service.fullSearch(text, min, max);
		
		return ResponseEntity.ok().body(list);
		
	}
	
	

}
