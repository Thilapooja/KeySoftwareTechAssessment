package com.example.techAssessment.service;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.stereotype.Service;

import com.example.techAssessment.entity.Category;
import com.example.techAssessment.repository.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepository=categoryRepo;
	}
	
	public Category createCategory(Category catergory) {
		return categoryRepository.save(catergory);
	}
	public List <Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	public Optional<Category> getCategory(Long id) {
		return categoryRepository.findById(id);
		
	}
	

}
