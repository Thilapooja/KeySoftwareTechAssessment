package com.example.techAssessment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techAssessment.entity.Attribute;
import com.example.techAssessment.service.AttributeService;

@RestController
@RequestMapping("/api/attributes")
public class AttributeController {
	private final AttributeService service;
	public AttributeController(AttributeService service) {
        this.service = service;
    }
	@PostMapping("/{category_id}")
	public ResponseEntity<Attribute> create(@PathVariable Long categoryId, @RequestBody Attribute attribute) {
        return ResponseEntity.ok(service.addAttribute(categoryId, attribute));
    }
	@GetMapping("/{category_id}")
	public ResponseEntity<List<Attribute>> getByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(service.getAttributesByCategory(categoryId));
    }

}
