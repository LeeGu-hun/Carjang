package controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.DaoMember;
import exception.AlreadyExistingMemberException;
import exception.IdPasswordNotMatchingException;
import exception.MemberNotFoundException;
import login.AuthInfo;
import login.AuthService;
import member.ChangePasswordService;
import member.ChangePwdCommand;
import member.ChangePwdCommandValidator;
import member.Member;
import member.MemberRegisterService;
import member.RegisterRequest;
import member.RegisterRequestValidator;

@Controller
public class MemberController {
	private DaoMember daoMember;
	private MemberRegisterService memberRegisterService;
	private ChangePasswordService changePasswordService;
	private AuthService authService;

	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}

	public void setDaoMember(DaoMember daoMember) {
		this.daoMember = daoMember;
	}

	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	@RequestMapping(value = "/member/regist", method = RequestMethod.POST)
	public String handleJoin(RegisterRequest rr, Errors errors, Model model, HttpSession session) {
		System.out.println("handleJoin");
		new RegisterRequestValidator().validate(rr, errors);
		if (errors.hasErrors())
			return "main";
		try {
			System.out.println("Controller " + rr.getEmail());
			memberRegisterService.regist(rr);
			model.addAttribute("memberName", rr.getName());
			return "main";
		} catch (AlreadyExistingMemberException ex) {
			errors.rejectValue("email", "duplicate");
			return "main";
		}
	}

	@RequestMapping("/detail/{id}")
	public String detail1(@PathVariable("id") String memId, Model model) {
		Member member = daoMember.selectById1(memId);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		model.addAttribute("member", member);
		return "member/memberDetail";
	}
	
	@RequestMapping(value="/member/myPage", method = RequestMethod.GET)
	public String detai2() {
		Member member = daoMember.selectById1(memId);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		model.addAttribute("member", member);
		return "member/memberDetail";
	}
	

	@RequestMapping(value = "/member/changePassword", method = RequestMethod.GET)
	public String form(@ModelAttribute("command") ChangePwdCommand pwdCmd) {
		return "member/myPage";
	}

	@RequestMapping(value = "/member/changePassword", method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") ChangePwdCommand pwdCmd, Errors errors, HttpSession session) {
		new ChangePwdCommandValidator().validate(pwdCmd, errors);
		if (errors.hasErrors()) {
			return "member/myPage";
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		try {
			changePasswordService.changePassword(authInfo.getEmail(), pwdCmd.getCurrentPassword(), pwdCmd.getNewPassword());
			return "member/myPage";
		} catch (IdPasswordNotMatchingException e) {
			errors.rejectValue("currentPassword", "notMatching");
			return "member/myPage";
		}
	}

	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException(TypeMismatchException ex) {
		return "member/invalidId";
	}

	@ExceptionHandler(MemberNotFoundException.class)
	public String handleNotFoundException() throws IOException {
		return "member/noMember";
	}

}
