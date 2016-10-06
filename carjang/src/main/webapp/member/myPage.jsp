<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>myPage</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body text="black" link="black" vlink="black" alink="black">
	<%@include file="/include/header.jsp"%>
	<div id="container">
		<div id="left">
			<div class="leftMenu" ><a href="#" style="text-decoration: none">내정보</a></div>
			<div class="leftMenu" ><a href="#" style="text-decoration: none">예약 확인/결제</a></div>
			<div class="leftMenu" ><a href="#" style="text-decoration: none">운전자 정보</a></div>
		</div>
		<div id="middle">></div>
		<div id="right">
			<div id="pwBox"> 
				<form action="${pageContext.request.contextPath}/member/changePassword" method="post" commandName="ChangePwdCommand">
				<div class="chgHeader" id="changedPwHeader">&nbsp;&nbsp;&nbsp;비밀번호 변경</div>
				<div id="changedPwContent">
					<label class="lblPw">현재 비밀번호</label><input type="password" class="password" name="currentPassword" id="pw1"/><br> 
					<label class="lblPw">새 비밀번호</label><input type="password" class="password" name="newPassword" id="pw2"/><br> 
					<label class="lblPw">비밀번호 확인</label><input type="password" class="password" name="confirmPassword" id="pw3"/><br>
				</div>
				<hr color="#dcdcdc" size="1">
				<div id="changedPwFooter">
					<button type="submit" id="changedPwBtn" >비밀번호 변경</button>
				</div>
				</form>
			</div>
			<div id="space"></div>
			<div id="useBox">
				<div class="chgHeader" id="useHeader">&nbsp;&nbsp;&nbsp;<label>${member.mem_name}님 탑승현황</label></div>
				<div id="useContent">
					<table>
						<tr>
							<th width="200" align="center" valign="top" height="40">이용횟수</th>
							<th width="200" align="center" valign="top" height="40">마일리지</th>
							<th width="200" align="center" valign="top" height="40">보유쿠폰</th>
						</tr>
						<tr>
							<td width="200" align="center" valign="top" height="40">${authInfo.count}</td>
							<td width="200" align="center" valign="top" height="40">${authInfo.mileage}</td>
							<td width="200" align="center" valign="top" height="40">10월 10% 할인쿠폰<br>초특가 95% 할인쿠폰</td>
						</tr>
					</table>
				</div>
			</div>
			
			<c:if test="${! empty driver }">
			<div id="useBox">
				<div class="chgHeader" id="useHeader">&nbsp;&nbsp;&nbsp;<label>${member.mem_name}님 운전현황</label></div>
				<div id="useContent2">
					<table>
						<tr>
							<th width="200" align="center" valign="top" height="40">이용횟수</th>
							<th width="200" align="center" valign="top" height="40">마일리지</th>
							<th width="200" align="center" valign="top" height="40">보유쿠폰</th>
						</tr>
						<tr>
							<td width="200" align="center" valign="top" height="40">${driver.drv_use}</td>
							<td width="200" align="center" valign="top" height="40">${authInfo.mileage}</td>
							<td width="200" align="center" valign="top" height="40">10월 10% 할인쿠폰<br>초특가 95% 할인쿠폰</td>
						</tr>
					</table>
				</div>
			</div>
			</c:if>
		</div>
	</div>
	<%@include file="/include/footer.jsp"%>
</body>
</html>