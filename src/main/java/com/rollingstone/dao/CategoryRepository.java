package com.rollingstone.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.Category;

public interface CategoryRepository extends PagingAndSortingRepository <Category, Long>{

}
