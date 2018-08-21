package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.IsolatedCartItem;

public interface CartItemRepository extends PagingAndSortingRepository <IsolatedCartItem, Long>{

}
