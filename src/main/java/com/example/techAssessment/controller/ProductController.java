package com.example.techAssessment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techAssessment.dto.ProductRequest;
import com.example.techAssessment.entity.Product;
import com.example.techAssessment.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	private final ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }
    @PostMapping("/{category_id}")
    public ResponseEntity<Product> create(@PathVariable Long categoryId,
            @RequestBody ProductRequest request) {
Product product = new Product();
product.setSku(request.getSku());
product.setName(request.getName());
product.setDescription(request.getDescription());
product.setBasePrice(request.getBasePrice());

return ResponseEntity.ok(service.createProduct(categoryId, product, request.getAttributes()));
}

@GetMapping
public ResponseEntity<List<Product>> all() {
return ResponseEntity.ok(service.getAllProducts());
}

}
