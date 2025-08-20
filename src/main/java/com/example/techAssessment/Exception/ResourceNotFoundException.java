package com.example.techAssessment.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException {
	public ResourceNotFoundException(String message) {
		super();
	}

	public Object getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
