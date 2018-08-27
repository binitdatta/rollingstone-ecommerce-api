package com.rollingstone.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.Address;
import com.rollingstone.service.AddressService;
import com.rollingstone.service.event.AddressServiceEvent;

@RestController
public class AddressController extends AbstractRestController {

	Logger logger = LoggerFactory.getLogger("AddressController");

	AddressService addressService;

	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@PostMapping("solcommerce/pdp-service/account/{accountId}/address")
	@ResponseBody
	public Address createAddress(@RequestBody Address address) {
		
		if (address.getAccount() == null) {
			logger.info("Account is null");
		}
		else {
			logger.info("Account is not null");
		}
		Address addressSaved = addressService.save(address);

		logger.info("Address Saved :" + addressSaved.toString());
		
		eventPublisher.publishEvent(new AddressServiceEvent(this, addressSaved, "AddressCreated" ));
		
		return address;
	}

	//Start Testing from here
	@GetMapping("solcommerce/pdp-service/account/{accountId}/address/{id}")
	public Address get(@PathVariable("id") Long id) {

		Optional<Address> addressRetreived = addressService.getAddress(id);
		Address address = addressRetreived.get();
		return address;
	}

	@GetMapping("solcommerce/pdp-service/account/{accountId}/address/bypage")
	Page<Address> getAddresssByPage(
			@RequestParam(value = "pagenumber", required = true, defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "pagesize", required = true, defaultValue = "20") Integer pageSize) {
		return addressService.getAddressByPage(pageNumber, pageSize);
	}

	@PutMapping("solcommerce/pdp-service/account/{accountId}/address/{id}")
	@ResponseBody
	public Address updateAddress(@RequestBody Address address) {
		Address addressSaved = addressService.save(address);

		logger.info("Address Updated :" + addressSaved.toString());
		return address;
	}

	/*---Delete a Address by id---*/
	@DeleteMapping("solcommerce/pdp-service/account/{accountId}/address/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		addressService.deleteAddress(id);
		return ResponseEntity.ok().body("Address has been deleted successfully.");
	}
}
