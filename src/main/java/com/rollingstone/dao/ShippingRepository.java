package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.Shipping;

public interface ShippingRepository extends PagingAndSortingRepository <Shipping, Long>{

}
