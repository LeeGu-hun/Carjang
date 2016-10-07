package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.DaoDriver;
import dao.DaoMember;
import driver.Driver;
import driver.DriverRegisterRequest;
import driver.DriverRegisterService;
import exception.AlreadyExistingMemberException;
import exception.IdPasswordNotMatchingException;
import exception.MemberNotFoundException;
import login.AuthInfo;
import login.AuthService;
import member.Car;
import member.ChangePasswordService;
import member.ChangePwdCommand;
import member.ChangePwdCommandValidator;
import member.Member;
import member.MemberRegisterService;
import member.RegisterRequest;
import model.CarService;
import model.DriverService;

@Controller
public class MemberController {
	private DaoMember daoMember;
	private DaoDriver daoDriver;
	private DriverRegisterService driverRegisterService;
	private MemberRegisterService memberRegisterService;
	private ChangePasswordService changePasswordService;
	private AuthService authService;
	private CarService carService;
	private DriverService driverService;

	
	public void setDriverRegisterService(DriverRegisterService driverRegisterService) {
		this.driverRegisterService = driverRegisterService;
	}

	public void setDaoDriver(DaoDriver daoDriver) {
		this.daoDriver = daoDriver;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	public void setDriverService(DriverService driverService) {
		this.driverService = driverService;
	}

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
		
		System.out.println("---회원가입---");
		System.out.println("가입 아이디 : " + rr.getEmail());
		
//		new RegisterRequestValidator().validate(rr, errors);
		if (errors.hasErrors()){
			return "main";
		}
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

	@RequestMapping(value = "/member/myPage/{email}", method = RequestMethod.GET)
	public String myPage(@PathVariable String email, HttpSession session, Model model) {

		System.out.println("---내정보---");
		System.out.println("내정보 아이디 : " + email);

		Member member = authService.authenticate(email + ".com");
		Driver driver = driverService.authenticate(email + ".com");

		if (member == null) {
			throw new MemberNotFoundException();
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		session.setAttribute("authInfo", authInfo);
		
		model.addAttribute("member", member);
		if(driver.getDrv_id().equals("notDriver")){
			System.out.println("notDriver");
			model.addAttribute("driver", "notDriver");
		}else{
			System.out.println("Driver");
			model.addAttribute("driver", driver);
		}
		
		return "member/myPage";
	}

	@RequestMapping(value = "/member/myPage4/{email}", method = RequestMethod.GET)
	public String myPage3(@PathVariable String email, HttpSession session, Model model) {

		System.out.println("---운전자 정보---");
		System.out.println("운전자 아이디 : " + email);

		Driver driver = driverService.authenticate(email + ".com");
		List<Car> car = carService.carInfo(email + ".com");
		int size = car.size();

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		session.setAttribute("authInfo", authInfo);
		
		model.addAttribute("page","mypage4");
		model.addAttribute("driver", driver);
		model.addAttribute("car", car);
		model.addAttribute("size", size);
		
		

		return "main";
	}
	
	@RequestMapping(value = "/driver/regist/{email}", method = RequestMethod.POST)
	public String myPage3(@PathVariable String email, DriverRegisterRequest drr, HttpSession session, Model model, Errors errors) {

		try {
			System.out.println("---운전자 등록---");
			System.out.println("등록 아이디 : " + email);
					
			driverRegisterService.regist(drr);
			model.addAttribute("page","mypage3");
			model.addAttribute("driverName", drr.getDrv_id());
			return "main";
		} catch (AlreadyExistingMemberException ex) {
			errors.rejectValue("email", "duplicate");
			return "main";
		}
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
			changePasswordService.changePassword(authInfo.getEmail(), pwdCmd.getCurrentPassword(),
					pwdCmd.getNewPassword());
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
