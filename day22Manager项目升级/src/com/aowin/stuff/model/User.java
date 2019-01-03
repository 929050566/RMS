package com.aowin.stuff.model;

public class User {

	private String username;
	private String password;
	private int permission;

	public User(String username, String password, int permission) {
		super();
		this.username = username;
		this.password = password;
		this.permission = permission;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", permission=" + permission + "]";
	}

	
	
}
