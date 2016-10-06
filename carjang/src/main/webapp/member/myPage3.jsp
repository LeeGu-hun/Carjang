<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>myPage3</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body text="black" link="black" vlink="black" alink="black">
	<%@include file="/include/header.jsp"%>
	<div id="container">
		<div id="left">
			<div class="leftMenu"><a href="#" style="text-decoration: none">내정보</a></div>
			<div class="leftMenu"><a href="#" style="text-decoration: none">예약 확인/결제</a></div>
			<div class="leftMenu"><a href="#" style="text-decoration: none">운전자 정보</a></div>
		</div>
		<div id="middle">></div>
		<div id="right">
			<div id="driverBox">
				<div class="chgHeader" id="changedPwHeader">&nbsp;&nbsp;&nbsp;운전자 정보 입력
				</div>
				<div id="driverContent">
					<span id="driverInfo">신상 정보</span>
					<hr color="#dcdcdc" size="1">
					<label class="lblDrvier">운전면허번호</label><input type="text" class="frmDriver" id="licenseNum"/>
					<input type="button" id="btnLicense"><br>
					<label class="lblDrvier">휴대폰 번호</label><input type="text" class="frmDriver" id="mobileNum"/><br>
					<label class="lblDrvier">보유차량</label><input type="text" class="frmDriver" id="car"/>
					<input type="button" id="btnCarAdd1"><br>
					<label class="lblDrvier">차량번호</label><input type="text" class="frmDriver" id="carNum"/>
					<label class="lblDrvier">차종</label><input type="text" class="frmDriver" id="carNum"/>
					<input type="button" id="btnCarAdd2"><br>
					<div id="line"></div>
					<span id="driverInfo">신상 정보</span>
					<hr color="#dcdcdc" size="1">
				</div>
				<div id=searchFooter> 
					<input type="button" id="register">
				</div>
			</div>
			<div id="space"></div>
		</div>
	<%@include file="/include/footer.jsp"%>
</body>
</html>