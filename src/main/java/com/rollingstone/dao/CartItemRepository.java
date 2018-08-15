package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.CartItem;

public interface CartItemRepository extends PagingAndSortingRepository <CartItem, Long>{

}
