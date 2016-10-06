<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style2.css" />
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(document).ready(
		function() {
	
			/* LoginModal */
			$("#menuLogin").click(function() {
				$("#loginModal").modal('show');
			});
			$('#btnJoin1').click(function() {
				$('#loginModal').modal('hide');
				$('#joinModal').modal('show');
			});
			/* joinModal */
			$("#menuJoin").click(function() {
				$("#joinModal").modal('show');
			});
			$('#btnLogin2').click(function() {
				$('#joinModal').modal('hide');
				$('#loginModal').modal('show');
			});
			$a = 1;
			$('#addBox').hide();
			
			$('#regBtn').click(function() {
				$('#addBox').toggle();
				
				if($a < 0) {
					$('#regBtn').attr('value', '카장등록');
					$('#regBtn').css('background', '#20b2aa');
					$a = $a * -1
				}
				else {
					$('#regBtn').attr('value', '등록취소');
					$('#regBtn').css('background', 'red');
					$a = $a * -1
				}
			});

			$('#menu3').click(function() {
				var url = "<%=request.getContextPath()%>/board";    
				$(location).attr('href',url);
			});
			
			$('#detail').click(function() {
			
			});
			
			$( ".star_rating a" ).click(function() {
			     $(this).parent().children("a").removeClass("on");
			     $(this).addClass("on").prevAll("a").addClass("on");
			     return false;
			});
			
			
		});
</script>		
<div id="headerBox">
	<div id="leftBox">
		<div id="logoImg">
			<img id="mini camper van" src="<%=request.getContextPath()%>/images/mini camper van.png">
		</div>
		<div id="logo">	We Together <span id="bar">|</span> Carjang~!</div>
		<div id="logoImg"><a href="#"><img id="mini camper van" src="<%=request.getContextPath()%>/images/mini camper van.png"></a></div>
		<div id="logo">&nbsp;&nbsp;&nbsp;We Together <span id="bar">|</span> Carjang~!</div>
	</div>
	<div id="rightBox">
		<div id="menuBox">
		<c:if test="${empty authInfo }">
			<div class="menu" id="menuLogin">
				<a href="#" style="text-decoration: none">로그인</a>
			</div>
			
			<div class="login-modal" id="loginModal" tabindex="-1" data-keyboard="true">
				<!-- data-backdrop="static" -->
				<div class="login-modal-dialog">
					<div class="login-modal-body">
					<c:if test="${empty cookie.REMEMBER.value}">
						<form action="${pageContext.request.contextPath}/login" commandName="loginCommand" method="post">
							<div class="login-group">
								<input class="login-control" placeholder="이메일 주소" type="text" name="email" id="email" /> 
								<input class="login-control" placeholder="비밀번호" type="password" name="password" id="password" /><br>
								<div id="checkId"><input name="rememberEmail" id="rememberEmail" type="checkbox" /><label id="lblSaveId">아이디 저장</label></div><br>
								<button class="btn_primary" type="submit" id="btnLogin1" />	로그인
							</div>
						</form>
					</c:if>
					<c:if test="${! empty cookie.REMEMBER.value}">
						<form action="${pageContext.request.contextPath}/login" commandName="loginCommand" method="post">
							<div class="login-group">
								<input class="login-control" placeholder="이메일 주소" type="text" name="email" id="email" value="${cookie.REMEMBER.value}" /> 
								<input class="login-control" placeholder="비밀번호" type="password" name="password" id="password" /><br>
								<div id="checkId"><input name="rememberEmail" id="rememberEmail" type="checkbox" checked/><label id="lblSaveId">아이디 저장</label></div><br>
								<button class="btn_primary" type="submit" id="btnLogin1" />	로그인
							</div>
						</form>
					</c:if>
					</div>
					<div class="modal-footer">
						<hr color="#d3d3d3" size="1">
						<span id="Q1">카장 계정이 없으세요?</span>
						<button id="btnJoin1" class="btn_primary">회원가입</button>
					</div>
				</div>
			</div>
			
			<div class=menu id=menuJoin> <a href="#" style="text-decoration: none">회원가입</a></div>		
			<div class="modal" id="joinModal" tabindex="-1" data-keyboard="true">
				<!-- data-backdrop="static" -->
				<div class="join-modal-dialog">
					<div class="join-modal-body">
						<form action="${pageContext.request.contextPath}/member/regist" method="post" commadname="registerRequest">
							<div class="join-group">
								<input class="join-control" placeholder="이름" type="text" name="name" id="joinUserName"> 
								<input class="join-control" placeholder="이메일" type="text" name="email" id="joinEmail"> 
								<input class="join-control" placeholder="비밀번호" type="password" name="password" id="joinPassword"> 
								<input class="join-control"	placeholder="비밀번호 확인" type="password" name="confirmpassword" id="confirmPassword"><br>
								<div id="agree">회원가입을 하면 카장의
												<span id="agree2">서비스 약관, 결제 서비스 약관, 개인정보 보호정책, 환불 정책</span>
												에 동의하는 것으로 간주됩니다.
								</div><br>  
								<input id="btnJoin2" type="submit" value="가입하기"/>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<hr color="#d3d3d3" size="1">
						<span id="Q2">이미 카장 계정이 있나요?</span>
						<button id="btnLogin2" class="btn_primary">로그인</button>
					</div>
				</div>
			</div>
			<div class=menu id=menu3>카장 이용하기</div>
			</c:if>
			<c:if test="${! empty authInfo }">
				${authInfo.name}님환영합니다.
				<div class=menu id=menuLogout><a href="${pageContext.request.contextPath}/logout" style="text-decoration: none">로그아웃</a></div>
				<div class=menu id=menuPwChange><a href="${pageContext.request.contextPath}/member/myPage/${authInfo.email}" style="text-decoration: none">마이페이지</a></div>
				<div class=menu id=menu3>카장 이용하기</div>
			</c:if>
		</div>
	</div>
</div>