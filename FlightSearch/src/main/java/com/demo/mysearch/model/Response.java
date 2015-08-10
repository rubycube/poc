package com.demo.mysearch.model;

public class Response {
	
	private User user;
	private Posts[] posts;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Posts[] getPosts() {
		return posts;
	}
	public void setPosts(Posts[] posts) {
		this.posts = posts;
	}
	
	
	

}
