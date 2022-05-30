package com.first.webservice.restwebservice.user;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.first.webservice.restwebservice.post.Post;

public class User {
	
	private Integer id;
	
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	
	@Past
	private Date birthDate;
	
	private List<Post> posts;
	
	protected User() {}
	
	

	public User(Integer id, String name, Date birthDate, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.posts = posts;
	}
	
	
	



	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", posts=" + posts + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getBirthDate()=" + getBirthDate() + ", getPosts()="
				+ getPosts() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	

}
