package com.duyhk.newswebsite.com.duyhk.newswebsite.models.responses;

import java.util.HashMap;
import java.util.Map;

public class ResponseService {
	
	private boolean validData = true;
	
	private Map<String, String> errors = new HashMap<>();

	public boolean isValidData() {
		return validData;
	}

	public void setValidData(boolean validData) {
		this.validData = validData;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public void addError(String fieldName, String errorMessage) {
		this.errors.put(fieldName, errorMessage);
	}

}
