package com.society.model.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

	public class PersonDto {
	private Long id;
		@Column(name = "first_name")
		private String firstName;
		@Column(name = "last_name")
		private String last_name;
		private String mobile_number;
		@Column(name = "email_id")
		private String email_id;
		private LocalDate dob;
		private String gender;
		private String city;
		private String state;
		private String username;
		private String password;
		@Column(name = "confirm_password")
		private String confirm_password;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return firstName;
	}
	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public PersonDto(Long id, String first_name, String last_name, String mobile_number, String email_id, LocalDate dob,
			String gender, String city, String state, String username, String password, String confirm_password) {
		super();
		this.id = id;
		this.firstName = first_name;
		this.last_name = last_name;
		this.mobile_number = mobile_number;
		this.email_id = email_id;
		this.dob = dob;
		this.gender = gender;
		this.city = city;
		this.state = state;
		this.username = username;
		this.password = password;
		this.confirm_password = confirm_password;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", first_name=" + firstName + ", last_name=" + last_name + ", mobile_number="
				+ mobile_number + ", email_id=" + email_id + ", dob=" + dob + ", gender=" + gender + ", city=" + city
				+ ", state=" + state + ", username=" + username + ", password=" + password + ", confirm_password="
				+ confirm_password + "]";
	}
	public PersonDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
