package member;

import org.springframework.transaction.annotation.Transactional;

import dao.DaoMember;
import exception.MemberNotFoundException;

public class ChangePasswordService {
	private DaoMember daoMember;

	public ChangePasswordService(DaoMember daoMember) {
		super();
		this.daoMember = daoMember;
	}

	@Transactional
	public void changePassword(String email, String oldPw, String newPw) {
		Member member = daoMember.selectById(email);
		if (member == null)
			throw new MemberNotFoundException();
		member.changePassword(oldPw, newPw);
		daoMember.update(member);
	}
}
