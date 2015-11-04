package com.mnlsolution.chime.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.mnlsolution.chime.domain.Account;

public class UserDetailsImpl extends User {

	private String nick;
	private String dept; 
	private Date regitime; 
 
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getRegitime() {
		return regitime;
	}

	public void setRegitime(Date regitime) {
		this.regitime = regitime;
	}

	public UserDetailsImpl(Account account) {
		super(account.getUserid(), account.getPassword(), authorities(account));
		this.nick = account.getNick();
		this.dept = account.getDept();
		this.regitime = account.getRegitime(); 
	}
	
	private static Collection<? extends GrantedAuthority> authorities(Account account) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(account.getRole()));
		return authorities;
	}


}
