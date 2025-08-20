package com.example.techAssessment.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long category_id;
	@Column(nullable = false,unique = true)
	private String name;
	private String description;
	@OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL)
	private List <Attribute> attributes = new ArrayList<>();
	@OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL)
	private List <Product> products = new ArrayList<>();
	

}
