package com.ac.rmexpapp.model;

public enum DeleteStaus {

	SUCCESSFULLY_DELETED(202, "Success"), 
	ERROR_WHILE_DELETING(404, "Error");

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private Integer code;
	private String message;

	private DeleteStaus(final Integer code, final String message) {
		this.code = code;
		this.message = message;
	}

}
