<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>myPage2</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body text="black" link="black" vlink="black" alink="black">
	<%@include file="/include/header.jsp"%>
	<div id="container"> 
		<div id="left">
			<div class="leftMenu">
				<a href="#" style="text-decoration: none">내정보</a>
			</div>
			<div class="leftMenu">
				<a href="#" style="text-decoration: none">예약 확인/결제</a>
			</div>
			<div class="leftMenu">
				<a href="#" style="text-decoration: none">운전자 정보</a>
			</div>
		</div>
		<div id="middle">></div>
		<div id="right">
			<div id="bookingBox">
				<div class="chgHeader" id="changedPwHeader">&nbsp;&nbsp;&nbsp;예약내역
				<input type="button" id="btnBooking" value="예약하기">
				</div>
				<div id="bookingContent">
					<table>
						<tr>
							<th width="75" align="center" valign="top" height="30">ID</th>
							<th width="75" align="center" valign="top" height="30">이름</th>
							<th width="75" align="center" valign="top" height="30">지역</th>
							<th width="75" align="center" valign="top" height="30">날짜</th>
							<th width="75" align="center" valign="top" height="30">이용시간</th>
							<th width="75" align="center" valign="top" height="30">차종</th>
							<th width="75" align="center" valign="top" height="30">인원수</th>
							<th width="75" align="center" valign="top" height="30">추가사항</th>
						</tr>
						<tr>
							<td width="75" align="center" valign="top" height="30"></td>
							<td width="75" align="center" valign="top" height="30"></td>
							<td width="75" align="center" valign="top" height="30"></td>
							<td width="75" align="center" valign="top" height="30"></td>
							<td width="75" align="center" valign="top" height="30"></td>
							<td width="75" align="center" valign="top" height="30"></td>
							<td width="75" align="center" valign="top" height="30"></td>
							<td width="75" align="center" valign="top" height="30"></td>
						</tr>
					</table>
				</div>
			</div>
			<div id="space"></div>
			
			<div id="paymentBox">
				<div class="chgHeader" id="changedPwHeader">&nbsp;&nbsp;&nbsp;결제내역
				<input type="button" id="btnPay" value="결제하기">
				</div>
				<div id="paymentContent">
					<table>
						<tr>
							<th width="135" align="center" valign="top" height="30">거래번호</th>
							<th width="135" align="center" valign="top" height="30">결제일</th>
							<th width="135" align="center" valign="top" height="30">결제금액</th>
							<th width="135" align="center" valign="top" height="30">마일리지</th>
							<th width="135" align="center" valign="top" height="30">결제 방식</th>
							<th width="135" align="center" valign="top" height="30">적용 쿠폰</th>
						</tr>
						<tr>
							<td width="135" align="center" valign="top" height="30"></td>
							<td width="135" align="center" valign="top" height="30"></td>
							<td width="135" align="center" valign="top" height="30"></td>
							<td width="135" align="center" valign="top" height="30"></td>
							<td width="135" align="center" valign="top" height="30"></td>
							<td width="135" align="center" valign="top" height="30"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/include/footer.jsp"%>
</body>
</html>