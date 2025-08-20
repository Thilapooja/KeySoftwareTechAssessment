package com.example.techAssessment.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;
	@ManyToOne
	@JoinColumn(name = "category" ,nullable = false)
	private Category category;
	@Column(nullable = false)
	private String name;
    
    @OneToMany(mappedBy = "Product" ,cascade = CascadeType.ALL)
    private List<ProductAttributeValue> attributes = new ArrayList<>();
	public void setSku(Object sku) {
		// TODO Auto-generated method stub
		
	}
	public void setName(Object name2) {
		// TODO Auto-generated method stub
		
	}
	public void setDescription(Object description2) {
		// TODO Auto-generated method stub
		
	}
	public void setBasePrice(Object basePrice) {
		// TODO Auto-generated method stub
		
	}
	public void setCategory(Optional<Category> category2) {
		// TODO Auto-generated method stub
		
	}
	public Object getProductId() {
		// TODO Auto-generated method stub
		return null;
	}
    

}
