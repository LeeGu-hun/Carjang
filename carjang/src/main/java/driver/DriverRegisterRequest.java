package driver;

public class DriverRegisterRequest {
	private String drv_id, drv_bank;
	private int drv_lisc, drv_phone, drv_mark, drv_use, drv_account;
	
	public DriverRegisterRequest(String drv_id, String drv_bank, int drv_lisc, int drv_phone, int drv_mark, int drv_use,
			int drv_account) {
		super();
		this.drv_id = drv_id;
		this.drv_bank = drv_bank;
		this.drv_lisc = drv_lisc;
		this.drv_phone = drv_phone;
		this.drv_mark = drv_mark;
		this.drv_use = drv_use;
		this.drv_account = drv_account;
	}

	public String getDrv_id() {
		return drv_id;
	}

	public void setDrv_id(String drv_id) {
		this.drv_id = drv_id;
	}

	public String getDrv_bank() {
		return drv_bank;
	}

	public void setDrv_bank(String drv_bank) {
		this.drv_bank = drv_bank;
	}

	public int getDrv_lisc() {
		return drv_lisc;
	}

	public void setDrv_lisc(int drv_lisc) {
		this.drv_lisc = drv_lisc;
	}

	public int getDrv_phone() {
		return drv_phone;
	}

	public void setDrv_phone(int drv_phone) {
		this.drv_phone = drv_phone;
	}

	public int getDrv_mark() {
		return drv_mark;
	}

	public void setDrv_mark(int drv_mark) {
		this.drv_mark = drv_mark;
	}

	public int getDrv_use() {
		return drv_use;
	}

	public void setDrv_use(int drv_use) {
		this.drv_use = drv_use;
	}

	public int getDrv_account() {
		return drv_account;
	}

	public void setDrv_account(int drv_account) {
		this.drv_account = drv_account;
	}
}
