<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search</title>
</head>
<body text="black" link="black" vlink="black" alink="black">
	<div class="searchContainer">
		<div class="searchBox">
			<form action="board/search" method="POST" commandName="boardSearch">

				&nbsp;&nbsp;&nbsp;실시간 검색 <input type="button" class="btnSrch"
					id="regBtn" value="카장등록"> <input class="btnSrch" type="submit"
					value="카장검색" />


				<table id="srchTable">
					<tr>
						<td width="220" align="center" valign="top"><label
							class="lblSrch">지역</label><select name="board_loc" class="area">
								<option>선택</option>
								<option value="서울">서울</option>
								<option selected="true" value="광주">광주</option>
								<option value="대구">대구</option>
								<option value="대전">대전</option>
								<option value="부산">부산</option>
								<option value="울산">울산</option>
								<option value="인천">인천</option>
								<option value="제주도">제주도</option>
								<option value="기타">기타</option>
						</select></td>
						<td width="300" align="center" valign="top"><label
							class="lblSrch">가용일</label> <input type="date" name="board_date1">&nbsp;
							<input type="time" name="board_time1"><br> <input
							type="date" name="board_date2" id="srchDate">&nbsp; <input
							type="time" name="board_time2" id="srchTime"></td>
						<td width="300" align="center" valign="top"><label
							class="lblSrch">가격(원)</label>&nbsp; <input type="number"
							name="board_price1"><br> <input type="number"
							name="board_price2"></td>
					</tr>
				</table>

			</form>
			<hr color="#dcdcdc" size="1">
			<div id="searchFooter"></div>
		</div>
		<div id="space"></div>

		<c:forEach var="data" items="${requestScope.board_list}">
			<div id="resultBox">

				<div class="searchHeader">
					<div class="srchTitle" id="searchTitle">&nbsp;&nbsp;&nbsp;카장
						검색 결과</div>
				</div>

				<div id="resultContent">
					<table id="resultTable">
					<input type="hidden" id="star_mark" value="${data.board_drv_makr}">
					
						<tr>
							<td width="200" align="center" valign="top">지역</td>
							<td width="200" align="center" valign="top">차량</td>
							<td width="200" align="center" valign="top">가격(원)</td>
							<td width="200" align="center" valign="top">별점</td>
						</tr>
						<tr>
							<td width="200" align="center" valign="top">${data.board_loc}</td>
							<td width="200" align="center" valign="top">${data.board_car}<br>
							</td>
							<td width="200" align="center" valign="top">${data.board_price}</td>
							<td>
							<div id="starDiv">
								<p class="star_rating">
	  							    <div id="star_on1" style="width:${data.board_drv_makr}%"></div>
	  							    <div id="star_on2" ></div>
								</p>
							</div>	
							</td>
						</tr>
					</table>
				</div>
				<hr color="#dcdcdc" size="1">
				<div id="searchFooter">
						<span id="detail">자세히▼</span>
						<table id="resultTable">
							<tr>
							<td width="200" align="center" valign="top">픽업</td>
							<td width="200" align="center" valign="top">
							<input type="checkbox" name="pickup_chk" checked="
							<c:if test="${data.board_pickup == '1'}">
   								checked
							</c:if>
							" onclick="return false;"></td>
							<td width="200" align="center" valign="top">희망인원</td>
							<td width="200" align="center" valign="top">${data.board_limit}</td>
							<td width="200" align="center" valign="top">코멘트</td>
							<td width="200" align="center" valign="top">${data.board_comment}</td>
							<td><input type="submit" value="예약"/></td>
							</tr>
						</table>					
					
				</div>

			</div>
		</c:forEach>

		<div id="space"></div>
		
		<div id="addBox">
			<form action="board/register" method="POST" commandName="boardInsert">
			<div class="searchHeader">
				<div class="srchTitle" id="addTitle">
					&nbsp;&nbsp;&nbsp;
					<input type="submit" class="btnAdd"
						value="카장등록">
				</div>
			</div>
			<div id="addContent">
				<table id="addTable">
					<tr>
						<td width="220" align="left" valign="top"><label id="lblAdd">지역</label>&nbsp;&nbsp;&nbsp;&nbsp;
						<select name="board_loc" class="area">
								<option>선택</option>
								<option value="서울">서울</option>
								<option value="광주">광주</option>
								<option value="대구">대구</option>
								<option value="대전">대전</option>
								<option value="부산">부산</option>
								<option value="울산">울산</option>
								<option value="인천">인천</option>
								<option value="제주도">제주도</option>
								<option value="기타">기타</option>
						</select></td>
						<td width="300" align="center" valign="top">
						<label class="lblSrch">가용일</label> 
						<input type="date" name="board_date1" id="addDate1">&nbsp;
						<input type="time" name="board_time1" id="addTime1"><br> 
						<input type="date" name="board_date2" id="addDate2">&nbsp;
						<input type="Time" name="board_time2" id="addTime2"></td>
						<td width="300" align="center" valign="top">
						<label class="lblSrch">가격(원)</label>&nbsp;
						<input type="number" name ="board_price"><br>

					</tr>
					<tr>
						<td width="180" align="center" valign="top"><label
							class="lblSrch">자동차</label><select name="board_car" class="area">
								<option>선택</option>
								<option value="렉서스">렉서스</option>
								<option value="롤스로이스">롤스로이스</option>
								<option value="링컨">링컨</option>
								<option value="미니">미니</option>
								<option value="벤츠">벤츠</option>
								<option value="부가티">부가티</option>
								<option value="아우디">아우디</option>
								<option value="포르쉐">포르쉐</option>
								<option value="BMW">BMW</option>
						</select>
						<td width="340" align="left" valign="top"><label id="lblEtc1">기타</label>
							<label id="lblEtc2">픽업</label>&nbsp;
							<input type="checkbox" name="pickup_chk" value="1"><br>
							<label id="lblEtc3" >희망인원</label> 
							<select name="board_limit"  id="number">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
						</select><br> 
						<label id="lblEtc4">코멘트</label>
							<input type="text" name="board_comment" >
							<input type="submit" value="등록" class="btnComment">&nbsp;
							<input type="reset" value="취소" class="btnComment">
					</tr>
				</table>
			</div>
			
			<hr color="#dcdcdc" size="1">
			<div id="addFooter"></div>
		</div>
		</form>
	</div>
</body>
</html>