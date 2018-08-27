package com.rollingstone.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.Account;
import com.rollingstone.service.AccountService;

@RestController
public class AccountController extends AbstractRestController {

	Logger logger  = LoggerFactory.getLogger("AccountController");
	
	AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping("solcommerce/pdp-service/account")
	@ResponseBody
	public Account createAccount(@RequestBody Account account) {
		Account accountSaved  = accountService.save(account);
		
		logger.info("Account Saved :"+ accountSaved.getAccountName());
		return account;
	}
	
	@GetMapping("solcommerce/pdp-service/account/{accountId}")
	public Account get(@PathVariable("accountId") Long accountId) {
		
		Optional<Account> accountRetreived  = accountService.getAccount(accountId);
		Account account = accountRetreived.get();
		return account;
	}
	
	@GetMapping("solcommerce/pdp-service/account/bypage")
	@ResponseBody
	Page<Account> getAccountsByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return accountService.getAccountByPage(pageNumber, pageSize);
	}
	
	@PutMapping("solcommerce/pdp-service/account/{id}")
	@ResponseBody
	public Account updateUser(@RequestBody Account account) {
		Account accountUpdated  = accountService.save(account);
		
		logger.info("User Updated :"+ accountUpdated.getAccountName());
		return accountUpdated;
	}
	
	 /*---Delete a Account by id---*/
	   @DeleteMapping("/solcommerce/pdp-service/account/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   accountService.deleteAccount(id);
	      return ResponseEntity.ok().body("Account has been deleted successfully.");
	   }
}
