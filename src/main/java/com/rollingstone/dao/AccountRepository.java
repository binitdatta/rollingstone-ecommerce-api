package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.Account;

public interface AccountRepository extends PagingAndSortingRepository <Account, Long>{

}
