package board;

import java.util.Date;

public class Board {

	private int board_num;
	private String board_drvId;
	private int board_price;
	private Date board_date1;
	private Date board_date2;
	private String board_loc;
	private int board_limit;
	private int board_pickup;
	private String board_comment;
	private Date board_regDate;
	private String board_car;

	public Board(int board_num, String board_drvId, int board_price, Date board_date1, Date board_date2,
			String board_loc, int board_limit, int board_pickup, String board_comment, Date board_regDate,
			String board_car) {
		super();
		this.board_num = board_num;
		this.board_drvId = board_drvId;
		this.board_price = board_price;
		this.board_date1 = board_date1;
		this.board_date2 = board_date2;
		this.board_loc = board_loc;
		this.board_limit = board_limit;
		this.board_pickup = board_pickup;
		this.board_comment = board_comment;
		this.board_regDate = board_regDate;
		this.board_car = board_car;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getBoard_drvId() {
		return board_drvId;
	}

	public void setBoard_drvId(String board_drvId) {
		this.board_drvId = board_drvId;
	}

	public int getBoard_price() {
		return board_price;
	}

	public void setBoard_price(int board_price) {
		this.board_price = board_price;
	}

	public Date getBoard_date1() {
		return board_date1;
	}

	public void setBoard_date1(Date board_date1) {
		this.board_date1 = board_date1;
	}

	public Date getBoard_date2() {
		return board_date2;
	}

	public void setBoard_date2(Date board_date2) {
		this.board_date2 = board_date2;
	}

	public String getBoard_loc() {
		return board_loc;
	}

	public void setBoard_loc(String board_loc) {
		this.board_loc = board_loc;
	}

	public int getBoard_limit() {
		return board_limit;
	}

	public void setBoard_limit(int board_limit) {
		this.board_limit = board_limit;
	}

	public int getBoard_pickup() {
		return board_pickup;
	}

	public void setBoard_pickup(int board_pickup) {
		this.board_pickup = board_pickup;
	}

	public String getBoard_comment() {
		return board_comment;
	}

	public void setBoard_comment(String board_comment) {
		this.board_comment = board_comment;
	}

	public Date getBoard_regDate() {
		return board_regDate;
	}

	public void setBoard_regDate(Date board_regDate) {
		this.board_regDate = board_regDate;
	}

	public String getBoard_car() {
		return board_car;
	}

	public void setBoard_car(String board_car) {
		this.board_car = board_car;
	}

}