package com.gcinemaflix.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue
	private Integer id;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	private Integer access;   //1 for admin and 0 for normal
	@JsonIgnore
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAccess() {
		return access;
	}
	public void setAccess(int access) {
		this.access = access;
	}
}
