package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.Promo;

public interface PromoRepository extends PagingAndSortingRepository <Promo, Long> {

}
