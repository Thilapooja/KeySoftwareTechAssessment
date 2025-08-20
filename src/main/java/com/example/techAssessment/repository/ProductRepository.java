package com.example.techAssessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.techAssessment.entity.Product;
import com.example.techAssessment.entity.ProductAttributeValue;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	void save(ProductAttributeValue pav);

}
