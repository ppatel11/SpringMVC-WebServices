package com.rest.sample.modal.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response extends GlobalApiResponse {
	
	public Response() {
		// TODO Auto-generated constructor stub
	}
	
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
