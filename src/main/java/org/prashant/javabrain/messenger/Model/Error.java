package org.prashant.javabrain.messenger.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Error {

	
	private String message;
	private int errorcode;
	private String documentation;
	
	
	public Error(String message, int errorcode, String documentation) {
		super();
		this.message = message;
		this.errorcode = errorcode;
		this.documentation = documentation;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	
}
