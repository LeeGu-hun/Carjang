package model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.DaoMember;
import exception.MemberNotFoundException;
import member.Car;

public class CarService {
	private DaoMember daoMember;

	@Autowired
	public void setDaoMember(DaoMember daoMember) {
		this.daoMember = daoMember;
	}	
	
	public List<Car> carInfo(String email) {
		List<Car> car = daoMember.selectById3(email);
		if (car == null) {
			throw new MemberNotFoundException();
		}
		return car;
	}
}
