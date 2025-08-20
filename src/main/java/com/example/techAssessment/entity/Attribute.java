package com.example.techAssessment.entity;

import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Attributes")
public class Attribute {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attribute_id;
	@ManyToOne
	@JoinColumn(name = "category_id" ,nullable = false)
	private Category category;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String data_type;
	private Boolean is_required=false;
	public void setCategory(Optional<Category> category2) {
		// TODO Auto-generated method stub
		
	}
	public Object getAttributeId() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
