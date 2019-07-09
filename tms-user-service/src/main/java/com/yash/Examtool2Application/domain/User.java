package com.yash.Examtool2Application.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "User Name is Required")
	private String name;
	private String phone;
	private String address;
	@NotBlank(message = "Login Name is Required")
	@Size(min = 1, max = 10, message = "Please provide 1 to 10 Characters")
	private String loginname;
	private String email;
	/**
	 * status of user 1: Active 2: Block By default user will be active at
	 * registration time
	 */
	private Integer status;
	/**
	 * Role of user 1: Admin 2: User By default role will be User
	 */
	private Integer role;
	@NotBlank(message = "Password is Required")
	private String password;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date created_at;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updated_at;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	@Override
	public String toString() {
		return "User1 [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", loginname="
				+ loginname + ", email=" + email + ", status=" + status + ", role=" + role + ", password=" + password
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}

}
