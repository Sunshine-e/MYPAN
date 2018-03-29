package com.ittahac.modal;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

	public final static int GENDER_MALE = 1;
	public final static int GENDER_FEMALE = 0;
	public final static int GENDER_PRIVACY = -1;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String nickname;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String email;
	private String phone;
	private int gender;
	private String address;
	private String sign;
	private Date registTime;
	private Date lastLoginTime;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		String sex = "保密";
		if (this.gender == GENDER_FEMALE) {
			sex = "女";
		}else if (this.gender == GENDER_MALE) {
			sex = "男";
		}else if (this.gender == GENDER_PRIVACY) {
			sex = "保密";
		}else {
			sex = "";
		}
		return sex;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSign() {
		if (this.sign == null || this.sign.equals("")) {
			this.sign = "这家伙很懒，什么都没写……";
		}
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
