package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rollingstone.domain.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository <User, Long>{

}
