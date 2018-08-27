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

import com.rollingstone.domain.Category;
import com.rollingstone.service.CategoryService;

@RestController
public class CategoryController extends AbstractRestController {

	Logger logger  = LoggerFactory.getLogger("CategoryController");
	
	CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping("solcommerce/pdp-service/category")
	@ResponseBody
	public Category createCategory(@RequestBody Category category) {
		Category categorySaved  = categoryService.save(category);
		
		logger.info("Category Saved :"+ categorySaved.toString());
		return category;
	}
	
	@GetMapping("solcommerce/pdp-service/category/{id}")
	public Category get(@PathVariable("id") Long id) {
		
		Optional<Category> categoryRetreived  = categoryService.getCategory(id);
		Category category = categoryRetreived.get();
		return category;
	}
	
	@GetMapping("solcommerce/pdp-service/category/bypage")
	Page<Category> getCategorysByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return categoryService.getCategoryByPage(pageNumber, pageSize);
	}
		
	
	@PutMapping("solcommerce/pdp-service/category/{id}")
	@ResponseBody
	public Category updateCategory(@RequestBody Category category) {
		Category categorySaved  = categoryService.save(category);
		
		logger.info("Category Updated :"+ categorySaved.toString());
		return category;
	}
	
	 /*---Delete a Category by id---*/
	   @DeleteMapping("solcommerce/pdp-service/category/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   categoryService.deleteCategory(id);
	      return ResponseEntity.ok().body("Category has been deleted successfully.");
	   }
}
