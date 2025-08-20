package com.example.techAssessment.entity;

import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_attribute_value")
public class ProductAttributeValue {
	@EmbeddedId
	private ProductAttributeKey id;
	@ManyToOne
	@MapsId("products_id")
	@JoinColumn(name = "attribute_id")
	private Attribute attribute;
	@Column(nullable = false)
	private String value;
	public void setId(ProductAttributeKey key) {
		// TODO Auto-generated method stub
		
	}
	public void setProduct(Product savedProduct) {
		// TODO Auto-generated method stub
		
	}
	public void setAttribute(Optional<Attribute> attr) {
		// TODO Auto-generated method stub
		
	}
	public void setValue(String value2) {
		// TODO Auto-generated method stub
		
	}

}
