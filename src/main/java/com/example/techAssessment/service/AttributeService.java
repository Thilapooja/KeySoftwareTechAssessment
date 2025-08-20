package com.example.techAssessment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.techAssessment.entity.Attribute;
import com.example.techAssessment.entity.Category;
import com.example.techAssessment.repository.AttributeRepository;
import com.example.techAssessment.repository.CategoryRepository;

@Service
public class AttributeService {
	private final AttributeRepository attributeRepository;
	private final CategoryRepository categoryRepository;
	public AttributeService(AttributeRepository attributeRepository,CategoryRepository categoryRepository) {
		this.attributeRepository=attributeRepository;
		this.categoryRepository=categoryRepository;
		
	}
	public Attribute addAttribute(Long category_id,Attribute attribute) {
		Optional<Category> category=categoryRepository.findById(category_id);
		attribute.setCategory(category);
		return attributeRepository.save(attribute);
	}
	public List<Attribute> getAttributesByCategory(Long category_id){
		return attributeRepository.findByCategoryCategoryId(category_id);
	}
	
	

}
