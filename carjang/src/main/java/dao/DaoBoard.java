package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import board.Board;
import board.BoardInsert;

public class DaoBoard {
	private JdbcTemplate jdbcTemplate;

	public DaoBoard(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List getBoardList(String loc, String date1, String date2, int price1, int price2)
			throws DataAccessException, ParseException {
		

		System.out.println(loc+ " "+datePicker("2016-10-06 14:00")+ " "+datePicker("2016-10-07 20:00")+""+price1+ " "+price2);
		
		List<Board> results = jdbcTemplate.query("select"
				+ " BOARD_NUM,BOARD_DRV_ID,BOARD_PRICE,BOARD_DATE_1,BOARD_DATE_2,"
				+ " BOARD_LOC,BOARD_LIMIT,BOARD_PICK_CHK,BOARD_COMENT,BOARD_REG_DATE,BOARD_CAR,DRV_MARK"
				+ " from RENTIT join DRIVER on RENTIT.BOARD_DRV_ID = DRIVER.DRV_ID where"
				+ " BOARD_LOC = ? AND BOARD_DATE_1 >= ? "
				+ " AND BOARD_DATE_2 <= ? AND BOARD_PRICE BETWEEN ? AND ? ", new RowMapper<Board>() {
					public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
						Board board = new Board(
								rs.getInt("BOARD_NUM"), rs.getString("BOARD_DRV_ID"),
								rs.getInt("BOARD_PRICE"), rs.getDate("BOARD_DATE_1"), 
								rs.getDate("BOARD_DATE_2"),rs.getString("BOARD_LOC"), 
								rs.getInt("BOARD_LIMIT"), rs.getInt("BOARD_PICK_CHK"),
								rs.getString("BOARD_COMENT"), rs.getDate("BOARD_REG_DATE"),
								rs.getString("BOARD_CAR"),rs.getInt("DRV_MARK"));
						return board;

					}

				}, loc,datePicker(date1), datePicker(date2), price1, price2);
		return results.isEmpty() ? null : results;
	}

	public void insert(BoardInsert board) {
		try {
			jdbcTemplate.update("insert into RENTIT (BOARD_NUM,BOARD_DRV_ID,BOARD_PRICE,BOARD_DATE_1,BOARD_DATE_2,BOARD_LOC,BOARD_LIMIT,BOARD_PICK_CHK,BOARD_COMENT,BOARD_CAR,BOARD_REG_DATE) values(board_seq.nextval,?,?,?,?,?,?,?,?,?,sysdate)",
					board.getBoard_drvId(), board.getBoard_price(), 
					datePicker(board.getBoard_date1()+" "+board.getBoard_time1()), 
					datePicker(board.getBoard_date2()+" "+board.getBoard_time2()),
					board.getBoard_loc(), board.getBoard_limit(), 
					board.getBoard_pickup(), board.getBoard_comment(),board.getBoard_car());
			
		} catch (DataAccessException e) {
			
			e.printStackTrace();
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	/*
	 * public void update(Member member) {
	 * jdbcTemplate.update("update MEMBER set NAME = ?, PASSWORD = ? " +
	 * "where EMAIL = ?", member.getName(), member.getPassword(),
	 * member.getEmail()); }
	 * 
	 * public void mDelete(Member member) {
	 * jdbcTemplate.update("delete from MEMBER where EMAIL = ?",
	 * member.getEmail()); }
	 */

	public Date datePicker(String date) throws ParseException {
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date1 = sdFormat.parse(date);
		System.out.println(date);
		return date1;
	}

}
