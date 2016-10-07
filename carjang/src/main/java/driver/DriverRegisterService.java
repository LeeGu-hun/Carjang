package driver;

import org.springframework.transaction.annotation.Transactional;

import dao.DaoDriver;
import exception.AlreadyExistingMemberException;

public class DriverRegisterService {
	private DaoDriver daoDriver;

	public DriverRegisterService(DaoDriver daoDriver) {
		this.daoDriver = daoDriver;
	}

	public DriverRegisterService() {
	}

	@Transactional
	public void regist(DriverRegisterRequest dreq) {
		Driver driver = daoDriver.selectById(dreq.getDrv_id());
		if (driver != null) {
			throw new AlreadyExistingMemberException("dup email " + dreq.getDrv_id());
		} else {
			/*
			<label class="lblDrvier">운전면허번호</label><input type="text" class="frmDriver" id="licenseNum" name="drv_lisc"/>
            <input type="button" value="면허조회" id="btnLicense"><br>
            <label class="lblDrvier">휴대폰 번호</label>&nbsp;&nbsp;<input type="text" class="frmDriver" id="mobileNum" name="drv_phone"/><br>
            
            <label class="lblDrvier">보유차량</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   <select name="carKind" class="carnum">
            <c:forEach var="data" items="${requestScope.car}">
				 	<option>${data.kind} / ${data.num }</option>
			   </c:forEach>
			   </select>
			   <!-- 셀렉트 는 어떻게 하지? -->
            <input type="button" value="차량추가" id="btnCarAdd1"><br>
            <label class="lblDrvier" id="carNumLabel">차량번호</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	<input type="text" class="frmDriver" id="carNum"/>
            <label class="lblDrvier" id="carKindLabel">차종</label>
            	<input type="text" class="frmDriver" id="carKind"/>
            <input type="button" value="추가" id="btnCarAdd2"><br>
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
         */
			Driver newDriver = new Driver(dreq.getDrv_id(), dreq.getDrv_lisc(), dreq.getDrv_phone(), 0, 0, dreq.getDrv_bank(), dreq.getDrv_account());
			System.out.println("Drsvc " + newDriver.getDrv_id());
			daoDriver.insert(newDriver);
		}
	}
}