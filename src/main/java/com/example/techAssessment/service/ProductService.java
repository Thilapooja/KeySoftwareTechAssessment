package com.example.techAssessment.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.techAssessment.entity.Attribute;
import com.example.techAssessment.entity.Category;
import com.example.techAssessment.entity.Product;
import com.example.techAssessment.entity.ProductAttributeKey;
import com.example.techAssessment.entity.ProductAttributeValue;
import com.example.techAssessment.repository.AttributeRepository;
import com.example.techAssessment.repository.CategoryRepository;
import com.example.techAssessment.repository.ProductAttributeValueRepository;
import com.example.techAssessment.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final AttributeRepository attributeRepository;
	private final ProductAttributeValueRepository productAttributeValueRepository;
	public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository,AttributeRepository attributeRepository,ProductAttributeValueRepository productAttributeValueRepository) {
		this.productRepository=productRepository;
		this.categoryRepository=categoryRepository;
		this.attributeRepository=attributeRepository;
		this.productAttributeValueRepository=productAttributeValueRepository;
		
	}
	@Transactional
	public Product createProduct(Long category_id, Product product, Map<Long, String> attributes) {
		Optional<Category> category=categoryRepository.findById(category_id);
		product.setCategory(category);
		Product savedProduct=productRepository.save(product);
		for (Map.Entry<Long, String> entry :attributes.entrySet()) {
			Optional<Attribute> attr=attributeRepository.findById(entry.getKey());
			 

	            ProductAttributeValue pav = new ProductAttributeValue();
	            ProductAttributeKey key = new ProductAttributeKey();
	            key.setProductId(savedProduct.getProductId());
	            
	            pav.setId(key);
	            pav.setProduct(savedProduct);
	            pav.setAttribute(attr);
	            pav.setValue(entry.getValue());

	            productRepository.save(pav);
		}
		return savedProduct;
	}
		public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }
	

}
