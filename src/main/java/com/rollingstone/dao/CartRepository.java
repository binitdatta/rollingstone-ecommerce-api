package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.Cart;

public interface CartRepository extends PagingAndSortingRepository <Cart, Long>{

}
