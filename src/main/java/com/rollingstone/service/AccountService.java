package com.rollingstone.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.AccountRepository;
import com.rollingstone.domain.Account;

@Service
public class AccountService {

	AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
/*	public AccountService() {
		super();
		
	}*/
	
	public Account save(Account account) {
		Account accountSaved = accountRepository.save(account);
		
		return accountSaved;
	}
	
	public Page<Account> getAccountByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("accountName").descending());
		
		
		return accountRepository.findAll(pageable);		
		
	}
	
	public Optional<Account> getAccount(Long accountId) {
		
		return accountRepository.findById(accountId);
	}
	
	public void deleteAccount(Long accountId) {
		accountRepository.deleteById(accountId);
	}
	
}
