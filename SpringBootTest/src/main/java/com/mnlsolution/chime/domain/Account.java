package com.mnlsolution.chime.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique=true)
	private  String userid;
	
	private String password;

	@Column(name = "role", nullable = false, length = 50)	
	private String role;

	@Column(name = "nick", length = 80)
	private String nick;
	
	@Column(name = "dept", nullable = true, length = 100)
	private String dept; 

	@Column(name = "regiTime", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regitime; 
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	

	public Date getRegitime() {
		return regitime;
	}

	public void setRegitime(Date regitime) {
		this.regitime = regitime;
	}
	
	
	

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", userid=" + userid + ", password=" + password + ", role=" + role + ", nick="
				+ nick + ", dept=" + dept + ", regitime=" + regitime + "]";
	}

	
	

	
	
	

	
	
	
	

}
