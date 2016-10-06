package member;

import java.util.Date;

import exception.IdPasswordNotMatchingException;

public class Member {
	private String mem_email, mem_password, mem_name;
	private int mem_count, mem_mileage;
	private Date date;
	
	public Member(String mem_email, String mem_password, String mem_name) {
		super();
		this.mem_email = mem_email;
		this.mem_password = mem_password;
		this.mem_name = mem_name;
	}
	/*
	public Member(String mem_email, String mem_password, String mem_name, int mem_count, int mem_mileage) {
		super();
		this.mem_email = mem_email;
		this.mem_password = mem_password;
		this.mem_name = mem_name;
		this.mem_count = mem_count;
		this.mem_mileage = mem_mileage;
	}*/

	
	public Member(String mem_email, String mem_password, String mem_name, int mem_count, int mem_mileage, Date date) {
		super();
		this.mem_email = mem_email;
		this.mem_password = mem_password;
		this.mem_name = mem_name;
		this.mem_count = mem_count;
		this.mem_mileage = mem_mileage;
		this.date = date;
	}

	
	public String getMem_email() {
		return mem_email;
	}


	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}


	public String getMem_password() {
		return mem_password;
	}


	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}


	public String getMem_name() {
		return mem_name;
	}


	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}


	public int getMem_count() {
		return mem_count;
	}


	public void setMem_count(int mem_count) {
		this.mem_count = mem_count;
	}


	public int getMem_mileage() {
		return mem_mileage;
	}


	public void setMem_mileage(int mem_mileage) {
		this.mem_mileage = mem_mileage;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public void changePassword(String oldPassword, String newPassword) {
		if (!mem_password.equals(oldPassword))
			throw new IdPasswordNotMatchingException();
		this.mem_password = newPassword;
	}
	
	public boolean matchPassword(String pw) {
		return (mem_password.equals(pw)) ? true : false;
	}
}