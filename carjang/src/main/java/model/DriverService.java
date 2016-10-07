package model;

import org.springframework.beans.factory.annotation.Autowired;

import dao.DaoDriver;
import driver.Driver;
import exception.MemberNotFoundException;

public class DriverService {
	private DaoDriver daoDriver;
	
	@Autowired
	public void setDaoDriver(DaoDriver daoDriver) {
		this.daoDriver = daoDriver;
	}
	
	public Driver authenticate(String email) {
		Driver driver = daoDriver.selectById(email);
		if (driver == null) {
			return new Driver("notDriver");
		}
		return new Driver(
				driver.getDrv_id(),
				driver.getDrv_lisc(),
				driver.getDrv_phone(),
				driver.getDrv_mark(),
				driver.getDrv_use(),
				driver.getDrv_bank(),
				driver.getDrv_account()
		);
	}
}
