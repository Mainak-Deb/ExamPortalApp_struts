package com.exam.form;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String uid;
    private String uname;
    private String uroll;
    private String urole;
    private String email;
    private String dob;
    
    // Getters and setters
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUroll() {
		return uroll;
	}
	public void setUroll(String uroll) {
		this.uroll = uroll;
	}
	public String getUrole() {
		return urole;
	}
	public void setUrole(String urole) {
		this.urole = urole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

}
