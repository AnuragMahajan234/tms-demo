package com.yash.Examtool2Application.exception;

public class LoginnameExceptionResponse {

	private String loginname;

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public LoginnameExceptionResponse(String loginname) {
		super();
		this.loginname = loginname;
	}
}
