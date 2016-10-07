<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>myPage3</title>
</head>
<script>
function settleFormCheck(){
    var frm = document.myPage3Form;
    
    AllSelect();
    frm.action = "${pageContext.request.contextPath}/driver/regist/${authInfo.email}";
    return true;
}
function AllSelect(){
    var obj = document.all.carKinds;
    
    try{
        for( var i=0 ; i<obj.length ; i++ ){
            obj.options[i].selected = true;
        }
    }catch(e){}
}
</script>
<body text="black" link="black" vlink="black" alink="black">
   <%@include file="/include/header.jsp"%>
   <div class="container">
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
         <div class="driverBox">
            <div class="myPage3Header">&nbsp;&nbsp;&nbsp;운전자 정보 입력
            </div>
            <form id="myPage3Form"name="myPage3Form"action="${pageContext.request.contextPath}/driver/regist/${authInfo.email}" method="post" command="driverRegisterRequest">
            <div class="driverContent">
               <span class="info">신상 정보</span>
               <hr color="#dcdcdc" size="1">
               <label class="lblDrvier">운전면허번호</label><input type="text" class="frmDriver" id="licenseNum" name="drv_lisc"/>
               <input type="button" value="면허조회" id="btnLicense"><br>
               <label class="lblDrvier">휴대폰 번호</label>&nbsp;&nbsp;<input type="text" class="frmDriver" id="mobileNum" name="drv_phone"/><br>
               <label class="lblDrvier">보유차량</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   <select name="carKinds" MULTIPLE id="carKinds" class="carnum" onsubmit="return settleFormCheck();">
			   </select>
			   <input type="hidden" name="drv_id" id="hidden"/> 
               <input type="button" value="차량추가" id="btnCarAdd1"><br>
               <label class="lblDrvier" id="carNumLabel">차량번호</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               	<input type="text" class="frmDriver" id="carNum"/>
               <label class="lblDrvier" id="carKindLabel">차종</label>
               	<input type="text" class="frmDriver" id="carKind"/>
               <input type="button" value="추가" id="btnCarAdd2" ><br>
               <div id="line"></div>
               <span class="info">거래정보</span>
               <hr color="#dcdcdc" size="1">
               <label class="lblDrvier">은행명</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="text" class="frmDriver" id="bank" name="drv_bank"/><br>
               <label class="lblDrvier">계좌번호</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="text" class="frmDriver" id="accountNum" name="drv_account"/>
               <input type="button" value="계좌조회" id="btnAccount"><br>
            </div>
            <hr color="#dcdcdc" size="1">
            <div id="myPage3Footer">
               <input type="submit" value="신규정보 등록" id="btnRegister">
            </div>
            </form>
         </div>
      </div>
      </div>
   <%@include file="/include/footer.jsp"%>
</body>
</html>