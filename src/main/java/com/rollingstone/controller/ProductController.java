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

import com.rollingstone.domain.Product;
import com.rollingstone.service.ProductService;

@RestController
public class ProductController extends AbstractRestController {

	Logger logger = LoggerFactory.getLogger("ProductController");

	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("solcommerce/pdp-service/product")
	@ResponseBody
	public Product createProduct(@RequestBody Product product) {
		Product productSaved = productService.save(product);

		logger.info("Product Saved :" + productSaved.toString());
		return product;
	}

	@GetMapping("solcommerce/pdp-service/product/{id}")
	public Product get(@PathVariable("id") Long id) {

		Optional<Product> productRetreived = productService.getProduct(id);
		Product product = productRetreived.get();
		return product;
	}

	@GetMapping("solcommerce/pdp-service/product/bypage")
	Page<Product> getProductsByPage(
			@RequestParam(value = "pagenumber", required = true, defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "pagesize", required = true, defaultValue = "20") Integer pageSize) {
		return productService.getProductByPage(pageNumber, pageSize);
	}

	@PutMapping("solcommerce/pdp-service/product/{id}")
	@ResponseBody
	public Product updateProduct(@RequestBody Product product) {
		Product productUpdated = productService.save(product);

		logger.info("Product Saved :" + productUpdated.toString());
		return product;
	}

	/*---Delete a Product by id---*/
	@DeleteMapping("solcommerce/pdp-service/product/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok().body("Product has been deleted successfully.");
	}
}
