package com.rollingstone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.PromoRepository;
import com.rollingstone.domain.Promo;

@Service
public class PromoService {

	PromoRepository promoRepository;

	public PromoService(PromoRepository promoRepository) {
		super();
		this.promoRepository = promoRepository;
	}
	
	
	public Promo save(Promo promo) {
		Promo promoSaved = promoRepository.save(promo);
		
		return promoSaved;
	}
	
	public Page<Promo> getPromoByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("promoCode").descending());
		
		
		return promoRepository.findAll(pageable);		
		
	}
	
	public Optional<Promo> getPromo(Long promoId) {
		
		return promoRepository.findById(promoId);
	}
	
	public void deletePromo(Long promoId) {
		promoRepository.deleteById(promoId);
	}
}
