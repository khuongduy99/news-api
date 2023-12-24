package com.duyhk.newswebsite.com.duyhk.newswebsite.models.responses;

import java.util.ArrayList;
import java.util.List;

public class ResponseService {
	
	private boolean validData = true;
	
	private List<String> messages = new ArrayList<>();

	public boolean isValidData() {
		return validData;
	}

	public void setValidData(boolean validData) {
		this.validData = validData;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	public void addMessage(String message) {
		this.messages.add(message);
	}
	
}
