package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.Product;

public interface ProductRepository extends PagingAndSortingRepository <Product, Long>{

}
