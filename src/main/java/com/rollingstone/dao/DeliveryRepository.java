package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.Delivery;

public interface DeliveryRepository extends PagingAndSortingRepository <Delivery, Long>{

}
