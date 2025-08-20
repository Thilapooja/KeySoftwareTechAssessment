package com.example.techAssessment.entity;

import java.util.Optional;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductAttributeKey {
	private Long products_id;
	private Long attribute_id;
	public void getAttributeId(Optional<Attribute>attributeId) {
		
	}
	public void setProductId(Object productId) {
		// TODO Auto-generated method stub
		
	}
	public void setAttributeId(Optional<Attribute> attributeId) {
		// TODO Auto-generated method stub
		
	}
	public Long getAttribute_id() {
		return attribute_id;
	}
	public void setAttribute_id(Long attribute_id) {
		this.attribute_id = attribute_id;
	}
	public Long getProduct_id() {
		return products_id;
	}
	public void setProduct_id(Long products_id) {
		this.products_id = products_id;
	}
	public Long getProducts_id() {
		return products_id;
	}
	public void setProducts_id(Long products_id) {
		this.products_id = products_id;
	}

}
