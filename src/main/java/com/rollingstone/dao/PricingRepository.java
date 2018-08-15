package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.Pricing;

public interface PricingRepository extends PagingAndSortingRepository <Pricing, Long>{

}
