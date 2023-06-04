package com.web.Model;

public class Account {
	private int id;
	private String username;
	private String password;
	private String role;
	private String encode;

	public Account(int id, String username, String password, String role, String encode) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.encode = encode;
	}

	public Account(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Account() {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}
}
