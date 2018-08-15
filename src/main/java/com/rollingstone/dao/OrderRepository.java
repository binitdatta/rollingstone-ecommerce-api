package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.Order;

public interface OrderRepository extends PagingAndSortingRepository <Order, Long>{

}
