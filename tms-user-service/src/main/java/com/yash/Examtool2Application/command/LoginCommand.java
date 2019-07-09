package com.yash.Examtool2Application.command;

import javax.validation.constraints.NotBlank;

public class LoginCommand {

	@NotBlank(message="Loginname cannot be blank")
	private String loginname;
	@NotBlank(message="Password cannot be blank")
	private String password;

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}