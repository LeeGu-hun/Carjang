package login;

import org.springframework.beans.factory.annotation.Autowired;

import dao.DaoMember;
import exception.IdPasswordNotMatchingException;
import exception.MemberNotFoundException;
import member.Driver;
import member.Member;

public class AuthService {
	private DaoMember daoMember;

	@Autowired
	public void setDaoMember(DaoMember daoMember) {
		this.daoMember = daoMember;
	}

	public AuthInfo authenticate(String email, String password) {
		Member member = daoMember.selectById(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		if (!member.matchPassword(password)) {
			throw new IdPasswordNotMatchingException();
		}
		return new AuthInfo(
				member.getMem_email(), 
				member.getMem_password(), 
				member.getMem_name(), 
				member.getMem_count(), 
				member.getMem_mileage(), 
				member.getDate()
		);
	}
	
	public DriverInfo authenticate2(String email) {
		Driver driver = daoMember.selectById2(email);
		if (driver == null) {
			throw new MemberNotFoundException();
		}
		return new DriverInfo(
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
