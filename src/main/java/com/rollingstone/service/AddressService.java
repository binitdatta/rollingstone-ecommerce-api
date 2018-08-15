package com.rollingstone.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.AddressRepository;
import com.rollingstone.domain.Address;

@Service
public class AddressService {
	
	Logger logger = LoggerFactory.getLogger("AddressService");


	AddressRepository addressRepository;

	public AddressService(AddressRepository addressRepository) {
		super();
		this.addressRepository = addressRepository;
	}
	
/*	public AddressService() {
		super();
		
	}*/
	
	public Address save(Address address) {
		
		if (address.getAccount() == null) {
			logger.info("Account is null");
		}
		else {
			logger.info("Account is not null");
		}
		
		Address addressSaved = addressRepository.save(address);
		
		return addressSaved;
	}
	
	public Page<Address> getAddressByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("houseNumber").descending());
		
		
		return addressRepository.findAll(pageable);		
		
	}
	
	public Optional<Address> getAddress(Long addressId) {
		
		return addressRepository.findById(addressId);
	}
	
	public void deleteAddress(Long addressId) {
		addressRepository.deleteById(addressId);
	}
}
