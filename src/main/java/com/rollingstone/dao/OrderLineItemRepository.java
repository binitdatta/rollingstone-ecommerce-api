package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.OrderLineItem;

public interface OrderLineItemRepository extends PagingAndSortingRepository <OrderLineItem, Long>{

}
