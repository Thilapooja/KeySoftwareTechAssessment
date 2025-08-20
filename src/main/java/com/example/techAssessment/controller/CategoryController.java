package com.example.techAssessment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.example.techAssessment.entity.Category;
import com.example.techAssessment.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	private final CategoryService service;
    public CategoryController(CategoryService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return ResponseEntity.ok(service.createCategory(category));
    }
    @GetMapping
    public ResponseEntity<List<Category>> all() {
        return ResponseEntity.ok(service.getAllCategories());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> get(@PathVariable Long id){
    	return ResponseEntity.ok(service.getCategory(id));
    }

}
