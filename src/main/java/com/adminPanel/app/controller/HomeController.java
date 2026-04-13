package com.adminPanel.app.controller;

import com.adminPanel.app.Entity.Product;
import com.adminPanel.app.Entity.ProductDetails;
import com.adminPanel.app.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import java.util.List;

@RestController
@RequestMapping("/products")
public class HomeController {

	private final ProductService productService;

	public HomeController(ProductService productService) {
		this.productService = productService;
	}


	@GetMapping("/")
	public List<Product> getAllProducts() {
		return productService.getProducts();
	}

	@GetMapping("/page")
	public List<Product> getProductsByPage(@RequestParam int page, @RequestParam int size) {
		return productService.getProducts(page, size).getContent();
	}
		@GetMapping("/{id}")
		public Product getProductById (@PathVariable Long id){
			return productService.getProductById(id);
		}


		// get details by id
		@GetMapping("/{id}/details")
		public ProductDetails getDetailsById (@PathVariable Long id){
			return productService.getProductById(id).getProductDetails();
		}
		// insert
		@PostMapping
		public Product addProduct (@RequestBody Product product){
			return productService.saveProduct(product);
		}
		//update
		@PutMapping("/{id}")
		public Product updateProduct(@PathVariable Long id, @RequestBody ProductDetails productDetails) {
			Product existingProduct = productService.getProductById(id);
			existingProduct.setName(productDetails.getName());
			existingProduct.getProductDetails().setName(productDetails.getName());
			existingProduct.getProductDetails().setExpirationDate(productDetails.getExpirationDate());
			existingProduct.getProductDetails().setManufacturer(productDetails.getManufacturer());
			existingProduct.getProductDetails().setPrice(productDetails.getPrice());
			existingProduct.getProductDetails().setAvailable(productDetails.isAvailable());
			return productService.saveProduct(existingProduct);
		}
		// delete
		@DeleteMapping("/{id}")
		public void deleteProductById ( @PathVariable long id){
			productService.deleteProduct(id);
		}


}

