<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search</title>
</head>
<body  text="black" link="black" vlink="black" alink="black">
	<%@include file="/include/header.jsp"%>
	<div class="searchContainer">
		<div class="searchBox">
			<div class="searchHeader">
				<div class="srchTitle" id="searchTitle">&nbsp;&nbsp;&nbsp;실시간 검색 
				<input type="button" class="btnSrch" value="카장등록"> <input type="button" class="btnSrch" value="카장검색">
				</div>
			</div>
			<div id="searchContent">
				<table id="srchTable">
					<tr>
						<td width="220" align="center" valign="top"><label class="lblSrch">지역</label><select name="area" class="area">
								<option>선택</option>
								<option value="seoul">서울</option>
								<option value="gwangju">광주</option>
								<option value="daegu">대구</option>
								<option value="daejeon">대전</option>
								<option value="busan">부산</option>
								<option value="ulsan">울산</option>
								<option value="incheon">인천</option>
								<option value="jeju">제주도</option>
								<option value="etc">기타</option>
						</select></td>
						<td width="300" align="center" valign="top">
							<label class="lblSrch">가용일</label><input type="date">&nbsp;<input type="time"><br> 
							<input type="date" id="srchDate">&nbsp;<input type="Time" id="srchTime"></td>
						<td width="300" align="center" valign="top">
							<label class="lblSrch">가격(원)</label>&nbsp;<input type="number"><br>
							<input type="number" id="srchPrice"></td>
					</tr>
				</table>
			</div>
			<hr color="#dcdcdc" size="1">
			<div id="searchFooter"></div>
		</div>
		<div id="space"></div>

		<div id="resultBox">
			<div class="searchHeader">
				<div class="srchTitle" id="searchTitle">&nbsp;&nbsp;&nbsp;카장 검색 결과</div>
			</div>
			<div id="resultContent">
				<table id="resultTable">
					<tr>
						<td width="200" align="center" valign="top">지역</td>
						<td width="200" align="center" valign="top">차량</td>
						<td width="200" align="center" valign="top">가격(원)</td>
						<td width="200" align="center" valign="top">별점</td>
					</tr>
					<tr>
						<td width="200" align="center" valign="top">서울</td>
						<td width="200" align="center" valign="top">차량<br>2명
						</td>
						<td width="200" align="center" valign="top">1,300,000</td>
						<td width="200" align="center" valign="top"></td>
					</tr>
				</table>
			</div>
			<hr color="#dcdcdc" size="1">
			<div id="searchFooter"><div><a href="#" style="text-decoration: none" id="detail">자세히▼</a></div></div>
		</div>

		<div id="space"></div>

		<div id="addBox">
			<div class="searchHeader">
				<div class="srchTitle" id="addTitle">
					&nbsp;&nbsp;&nbsp;카장 등록 <input type="button" class="btnAdd"	value="카장등록">
				</div>
			</div>
			<div id="addContent">
				<table id="addTable">
					<tr>
						<td width="220" align="left" valign="top"><label id="lblAdd">지역</label>&nbsp;&nbsp;&nbsp;&nbsp;<select
							name="area" class="area">
								<option>선택</option>
								<option value="seoul">서울</option>
								<option value="gwangju">광주</option>
								<option value="daegu">대구</option>
								<option value="daejeon">대전</option>
								<option value="busan">부산</option>
								<option value="ulsan">울산</option>
								<option value="incheon">인천</option>
								<option value="jeju">제주도</option>
								<option value="etc">기타</option>
						</select></td>
						<td width="300" align="center" valign="top"><label
							class="lblSrch">가용일</label> <input type="date" id="addDate1">&nbsp;<input
							type="time" id="addTime1"><br> <input type="date"
							id="addDate2">&nbsp;<input type="Time" id="addTime2"></td>
						<td width="300" align="center" valign="top"><label
							class="lblSrch">가격(원)</label>&nbsp;<input type="number"><br>
							<input type="number" id="addPrice"></td>
					</tr>
					<tr>
						<td width="180" align="center" valign="top"><label
							class="lblSrch">자동차</label><select name="area" class="area">
								<option>선택</option>
								<option value="lexus">렉서스</option>
								<option value="rolls-royce">롤스로이스</option>
								<option value="lincoln">링컨</option>
								<option value="mini">미니</option>
								<option value="benz">벤츠</option>
								<option value="bugatti">부가티</option>
								<option value="audi">아우디</option>
								<option value="porsche">포르쉐</option>
								<option value="BMW">BMW</option>
						</select>
						<td width="340" align="left" valign="top"><label id="lblEtc1">기타</label>
							<label id="lblEtc2">픽업</label>&nbsp;<input type="checkbox"><br>
							<label id="lblEtc3">희망인원</label> <select name="number"
							id="number">
								<option value="one">1</option>
								<option value="two">2</option>
								<option value="three">3</option>
								<option value="four">4</option>
								<option value="five">5</option>
								<option value="six">6</option>
						</select><br> <label id="lblEtc4">코멘트</label><input type="text">
							<input type="submit" value="등록" class="btnComment">&nbsp;<input
							type="reset" value="취소" class="btnComment">
					</tr>
				</table>
			</div>
			<hr color="#dcdcdc" size="1">
			<div id="addFooter"></div>
		</div>
	</div>
	<%@include file="/include/footer.jsp"%>
</body>
</html>