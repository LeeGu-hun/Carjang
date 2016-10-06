package member;

import org.springframework.transaction.annotation.Transactional;

import dao.DaoMember;
import exception.AlreadyExistingMemberException;

public class MemberRegisterService {
	private DaoMember daoMember;

	public MemberRegisterService(DaoMember daoMember) {
		this.daoMember = daoMember;
	}

	public MemberRegisterService() {
	}

	@Transactional
	public void regist(RegisterRequest req) {
		Member member = daoMember.selectById(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		} else {
			Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName());
			System.out.println("rsvc " + newMember.getMem_email());
			daoMember.insert(newMember);
		}
	}
}