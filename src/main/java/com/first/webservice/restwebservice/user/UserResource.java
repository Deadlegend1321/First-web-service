package com.first.webservice.restwebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.first.webservice.restwebservice.post.Post;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user =  service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder.
		fromCurrentRequest().
		path("/{id}").
		buildAndExpand(savedUser.getId()).toUri();
	
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/users/{id}/posts")
	public List<Post> retreiveAllPosts(@PathVariable int id){
		return service.findAll(id);
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createPost(@RequestBody Post post, @PathVariable int id) {
		Post savedPost = service.save(post, id);
		
		URI location = ServletUriComponentsBuilder.
		fromCurrentRequest().
		path("/{id}").
		buildAndExpand(savedPost.getPost_id()).toUri();
	
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/users/{id}/posts/{post_id}")
	public Post retrievePost(@PathVariable int id, @PathVariable int post_id) {
		Post post =  service.findOnePost(id, post_id);
		if(post == null) {
			throw new UserNotFoundException("post_id-" + post_id);
		}
		return post;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("id-" + id);
		}
	}
}
