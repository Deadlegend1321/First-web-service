package com.first.webservice.restwebservice.post;

import java.util.Date;

public class Post {
	
	private Integer post_id;
	
	private String image_url;
	
	private Date post_date;
	
	protected Post() {}

	public Post(Integer post_id, String image_url, Date post_date) {
		super();
		this.post_id = post_id;
		this.image_url = image_url;
		this.post_date = post_date;
	}

	public Integer getPost_id() {
		return post_id;
	}

	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	
	

}
