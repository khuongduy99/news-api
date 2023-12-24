package com.duyhk.newswebsite.com.duyhk.newswebsite.models.responses;

import java.util.List;

public class ResponseMultiMessage {
	private List<String> messages;

	public ResponseMultiMessage(List<String> messages) {
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
