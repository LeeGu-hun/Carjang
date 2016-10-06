package model;

import org.springframework.beans.factory.annotation.Autowired;

import dao.DaoMember;
import exception.IdPasswordNotMatchingException;
import exception.MemberNotFoundException;
import member.Driver;
import member.Member;

public class DriverService {
	private DaoMember daoMember;

	@Autowired
	public void setDaoMember(DaoMember daoMember) {
		this.daoMember = daoMember;
	}	
	
	public Driver authenticate(String email) {
		Driver driver = daoMember.selectById2(email);
		if (driver == null) {
			throw new MemberNotFoundException();
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
