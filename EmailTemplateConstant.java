package com.gsyw.gfits.commons.util;

public enum EmailTemplateConstant {

	SIGN_UP_REQUEST_USER_AND_APPROVER_TEMPLATE("SIGN-UP-REQUEST-USER-AND-APPROVER-TEMPLATE"),
	SIGN_UP_REQUEST_USER_TEMPLATE("SIGN-UP-REQUEST-USER-TEMPLATE"),
	SIGN_UP_REQUEST_APPROVER_TEMPLATE("SIGN-UP-REQUEST-APPROVER-TEMPLATE"),
	SIGN_UP_REQUEST_APPROVE_REJECT_TEMPLATE_FOR_USER("SIGN-UP-REQUEST-APPROVE-REJECT-TEMPLATE-FOR-USER"),
	SIGN_UP_REQUEST_APPROVE_REJECT_TEMPLATE_FOR_APPROVER("SIGN-UP-REQUEST-APPROVE-REJECT-TEMPLATE-FOR-APPROVER"),
	SEND_RANDOM_CODE_TO_USER("SEND-RANDOMM-CODE-TO-USER");

	private EmailTemplateConstant(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

}
