<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>myPage4</title>
</head>
<body text="black" link="black" vlink="black" alink="black">
  
   <div class="container">
      <div id="left">
         <div class="leftMenu">
            <a href="${pageContext.request.contextPath}/member/myPage/${authInfo.email}" style="text-decoration: none">내정보</a></div>
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
         <div class="driverBox">
            <div class="myPage3Header">&nbsp;&nbsp;&nbsp;운전자 정보 입력</div>
            <div class="driverContent">
               <span class="info">신상 정보</span>
               <hr color="#dcdcdc" size="1">
               <form>
               <label class="lblDrvier">운전면허번호</label><input type="text" class="frmDriver" id="licenseNum" value="${driver.drv_lisc }"/>
               <input type="button" value="면허조회" id="btnLicense"><br> 
               <label class="lblDrvier">휴대폰 번호</label>&nbsp;&nbsp;<input type="text" class="frmDriver" id="mobileNum" value="${driver.drv_phone }"/><br> 
               <label class="lblDrvier">보유차량</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <select name="carKinds" id="carKinds" class="carnum" >
               <c:forEach var="data" items="${requestScope.car}">
				 	<option>${data.kind} / ${data.num }</option>
				</c:forEach>
				</select>
               <input type="button" value="차량추가" id="btnCarAdd1" ><br>
               <label class="lblDrvier" id="carNumLabel">차량번호</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="frmDriver" id="carNum"/>        
				<label class="lblDrvier" id="carKindLabel">차종</label><input type="text" class="frmDriver" id="carKind"/>
               <input type="submit" value="추가" id="btnCarAdd2"><br>
               </form>
               <label class="lblDrvier">별점</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="frmDriver" id="carNum" /><br> 
               <span id="dealInfo">거래정보</span>
               <hr color="#dcdcdc" size="1">
               <label class="lblDrvier">은행명</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="frmDriver" id="bank" value="${driver.drv_bank }"/><br> 
               <label class="lblDrvier">계좌번호</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="frmDriver" id="accountNum" value="${driver.drv_account }" /> 
               <input type="button" value="계좌조회" id="btnAccount"><br>
            </div>
            <hr color="#dcdcdc" size="1">
            <div id="myPage3Footer">
               <input type="button" value="변경내용 저장" id="btnRegister">
            </div>
            <div id="space"></div>
            <div class="driverBox">
               <div class="myPage3Header">&nbsp;&nbsp;&nbsp;운전자 정보 입력</div>
               <div id="registerStateContent">
                  <table>
                     <tr>
                        <th width="100" align="center" valign="top" height="30">날짜</th>
                        <th width="100" align="center" valign="top" height="30">지역</th>
                        <th width="100" align="center" valign="top" height="30">가격</th>
                        <th width="100" align="center" valign="top" height="30">차종</th>
                        <th width="100" align="center" valign="top" height="30">희망인원</th>
                        <th width="100" align="center" valign="top" height="30">픽업여부</th>
                        <th width="230" align="center" valign="top" height="30">추가사항</th>
                     </tr>
                     <tr>
                        <td width="100" align="center" valign="top" height="30"></td>
                        <td width="100" align="center" valign="top" height="30"></td>
                        <td width="100" align="center" valign="top" height="30"></td>
                        <td width="100" align="center" valign="top" height="30"></td>
                        <td width="100" align="center" valign="top" height="30"></td>
                        <td width="100" align="center" valign="top" height="30"></td>
                        <td width="230" align="center" valign="top" height="30"></td>
                     </tr>
                  </table>
               </div>
            </div>
         </div>
      </div>
   </div>
   
</body>
</html>