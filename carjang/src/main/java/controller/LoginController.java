package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.BoardCommand;
import exception.AlreadyExistingMemberException;
import exception.IdPasswordNotMatchingException;
import exception.MemberNotFoundException;
import login.AuthInfo;
import login.AuthService;
import login.DriverInfo;
import login.LoginCommand;
import login.LoginCommandValidator;
import member.MemberRegisterService;
import member.RegisterRequest;
import member.RegisterRequestValidator;

@Controller
public class LoginController {
	private AuthService authService;
	private MemberRegisterService memberRegisterService;

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	@RequestMapping("/")
	public String root(RegisterRequest rr, Errors errors) {
		if (rr.getEmail() != null && !rr.getEmail().equals("")) {
			new RegisterRequestValidator().validate(rr, errors);
			if (errors.hasErrors())
				return "main";
			try {
				memberRegisterService.regist(rr);
				return "main";
			} catch (AlreadyExistingMemberException ex) {
				errors.rejectValue("email", "duplicate");
				return "main";
			}
		} else {
			return "main";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String form(LoginCommand loginCommand, @CookieValue(value = "REMEMBER", required = false) Cookie rCookie) {
		if (rCookie != null) {
			loginCommand.setEmail(rCookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		return "main";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String form(LoginCommand loginCommand, Errors errors, BoardCommand boardCmd, HttpSession session, HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if (errors.hasErrors()) {
			return "main";
		}
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			session.setAttribute("authInfo", authInfo); //세션값을 고정(로그인 성공)
			
			/*
			DriverInfo driverInfo = authService.authenticate2(loginCommand.getEmail());
			if(driverInfo != null){
				session.setAttribute("driverInfo", driverInfo); //세션값을 고정(운전자 정보)
			}else{
			}
			*/
			
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
			rememberCookie.setPath("/");
			
			if (loginCommand.isRememberEmail()) { //이메일 저장 유효기간
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			return "main";
		} catch (MemberNotFoundException e) {
			errors.reject("memberNotFound");
			return "main";
		} catch (IdPasswordNotMatchingException e) {
			errors.reject("idPasswordNotMatching");
			return "main";
		}
	}

	@RequestMapping("/logout")
	public String form(HttpSession session) {
		session.invalidate();
		return "main";
	}
}
