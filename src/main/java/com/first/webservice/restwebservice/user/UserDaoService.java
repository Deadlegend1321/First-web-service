package com.first.webservice.restwebservice.user;

import java.util.*;

import org.springframework.stereotype.Component;

import com.first.webservice.restwebservice.post.Post;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	private static List<Post> posts = new ArrayList<>();
	private static int postsCount = 1;
	
	static {
		posts.add(new Post(1, "dgfggdgvdf", new Date()));
		users.add(new User(1, "Mudit", new Date(), posts));
		users.add(new User(2, "Hui", new Date(), posts));
		users.add(new User(3, "Hola", new Date(), posts));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public List<Post> findAll(int userId){
		User user =  findOne(userId);
		if(user == null) {
			throw new UserNotFoundException("id-" + userId);
		}
		return user.getPosts();
	}
	
	public Post save(Post post, int userId) {
		User user =  findOne(userId);
		if(user == null) {
			throw new UserNotFoundException("id-" + userId);
		}
		if(!user.getPosts().contains(post)) {
			post.setPost_id(++postsCount);
		}
		user.getPosts().add(post);
		return post;
	}
	
	public Post findOnePost(int userId, int id) {
		User user =  findOne(userId);
		if(user == null) {
			throw new UserNotFoundException("id-" + userId);
		}
		for(Post post : user.getPosts()) {
			if(post.getPost_id() == id) {
				return post;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
