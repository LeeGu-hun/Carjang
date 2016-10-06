package login;

import java.util.Date;

public class AuthInfo {
	private String email, password, name;
	private int count, mileage;
	private Date date;
	
	public AuthInfo(String email, String password, String name, int count, int mileage, Date date) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.count = count;
		this.mileage = mileage;
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	
}
