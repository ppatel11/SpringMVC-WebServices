package com.rest.sample.modal.response;

import java.util.ArrayList;
import java.util.List;

public class GlobalApiResponse {
	
	private List<String> message;
	
	private int resultCode;

	public List<String> getMessage() {
		if(message == null) {
			message = new ArrayList<String>();
		}
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
}
