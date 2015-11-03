package com.mnlsolution.chime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mnlsolution.chime.domain.Account;

 

public interface AccountRepository extends JpaRepository<Account, Long>{
	public Account findByUserid(String userid);
}