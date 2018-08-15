package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.Address;

public interface AddressRepository extends PagingAndSortingRepository <Address, Long>{

}
