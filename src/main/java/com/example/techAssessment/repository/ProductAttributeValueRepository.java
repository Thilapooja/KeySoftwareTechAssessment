package com.example.techAssessment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.techAssessment.entity.ProductAttributeKey;
import com.example.techAssessment.entity.ProductAttributeValue;

@Repository
public class ProductAttributeValueRepository extends  JpaRepository<ProductAttributeValue,ProductAttributeKey>{
	

}
