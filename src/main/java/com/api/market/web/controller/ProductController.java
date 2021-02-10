package com.api.market.web.controller;

import com.api.market.domain.Product;
import com.api.market.domain.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v0")
@Api(value = "Products", description = "REST API for manage Products", tags = { "Products" })
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	@ApiOperation("Get all supermarket products")
	@ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/products/{product-id}")
	@ApiOperation("Search a product with an ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 404, message = "Product not found"),
	})
	public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of the product", required = true, example = "7")
						@PathVariable("product-id") int productId) {
		return productService.getProduct(productId)
			.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
			.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/products/category/{category-id}")
	@ApiOperation("Get all products according to a category")
	@ApiResponses({
                @ApiResponse(code = 200, message = "OK"),
                @ApiResponse(code = 404, message = "Products not found"),
        })
	public ResponseEntity<List<Product>> getByCategory(@PathVariable("category-id") int categoryId) {
		return productService.getByCategory(categoryId)
			.map(products -> new ResponseEntity<>(products, HttpStatus.OK))
			.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/products")
	@ApiOperation("Create product")
        @ApiResponse(code = 201, message = "CREATED")
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/products/{product-id}")
	@ApiOperation("Delete product with an ID")
        @ApiResponses({
                @ApiResponse(code = 200, message = "OK"),
                @ApiResponse(code = 404, message = "Product not found"),
        })
	public ResponseEntity delete(@PathVariable("product-id") int productId) {
		return productService.delete(productId) ? 
			new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}
