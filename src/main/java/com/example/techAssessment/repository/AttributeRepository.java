package com.example.techAssessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.techAssessment.entity.Attribute;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long>{
	List<Attribute> findByCategoryCategoryId(Long category_id);
	

}
