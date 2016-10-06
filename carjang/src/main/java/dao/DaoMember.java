package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import member.Driver;
import member.Member;

public class DaoMember {
	private JdbcTemplate jdbcTemplate;

	public DaoMember(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*
 		고객 디테일 검색
	 */
	public Member selectById(String memId) {
		List<Member> results = jdbcTemplate.query("SELECT * FROM MEMBER WHERE MEM_ID = ? ", new RowMapper<Member>() {
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
						rs.getString("MEM_ID"), 
						rs.getString("MEM_PW"), 
						rs.getString("MEM_NAME"),
						rs.getInt("MEM_COUNT"),
						rs.getInt("MEM_MILEAGE"),
						rs.getTimestamp("MEM_DATE"));
					return member;
			}
		}, memId);
		return results.isEmpty() ? null : results.get(0);
	}
	
	/*
	 	운전자 디테일 검색
	 */
	public Driver selectById2(String memId) {
		List<Driver> results = jdbcTemplate.query(
				"SELECT * FROM DRIVER WHERE DRV_ID = ?", new RowMapper<Driver>() {
			public Driver mapRow(ResultSet rs, int rowNum) throws SQLException {
				Driver driver = new Driver(
						rs.getString("DRV_ID"), 
						rs.getInt("DRV_LISC"), 
						rs.getInt("DRV_PHONE"),
						rs.getInt("DRV_MARK"), 
						rs.getInt("DRV_USE"), 
						rs.getString("DRV_BANK"),
						rs.getInt("DRV_ACCOUNT"));
				return driver;
			}
		}, memId);
		return results.isEmpty() ? null : results.get(0);
	}
	/*
	public List<Member> selectByRegdate(Date from, Date to) {
		List<Member> results = jdbcTemplate.query(
			"select * from MEMBER where REGDATE between ? and ? "
			+ "order by REGDATE desc ", 
			new RowMapper<Member>() { 
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(
								rs.getString("MEM_ID"), 
								rs.getString("MEM_PW"), 
								rs.getString("MEM_NAME"),
								rs.getInt("MEM_COUNT"), 
								rs.getInt("MEM_MILEAGE"),
								rs.getTimestamp("REGDATE"));
								return member;
				}
		}, from, to);
		return results;
	}
	*/
	
	/*
	 	총인원 목록
	 */
	public List<Member> selectAll() {		
		int total = count();//총인원
		List<Member> results = jdbcTemplate.query(
				"SELECT * FROM MEMBER", new RowMapper<Member>() {
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
						rs.getString("MEM_ID"), 
						rs.getString("MEM_PW"), 
						rs.getString("MEM_NAME"),
						rs.getInt("MEM_COUNT"), 
						rs.getInt("MEM_MILEAGE"), 
						rs.getTimestamp("REGDATE"));
				return member;
			}
		});
		return results;
	}
	
	/*
	 	총인원수
	 */
	public int count() {
		Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", Integer.class);
		return count;
	}
	
	/*
	 	회원가입
	 */
	public void insert(final Member member) {
		
		System.out.println("---INSERT---");
		System.out.println("EMAIL : " + member.getMem_email());
		System.out.println("PASSWORD : " + member.getMem_password());
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement( "INSERT INTO MEMBER " + " VALUES(?, ?, ?, ?, ?, sysdate)");
					pstmt.setString(1, member.getMem_email());
					pstmt.setString(2, member.getMem_password());
					pstmt.setString(3, member.getMem_name());
					pstmt.setInt(4, 0);
					pstmt.setInt(5, 0);
				return pstmt;
			}
		});
	}
	
	/*
		비밀번호 수정
	*/
	public void update(Member member) {
		
		System.out.println("---MODIFY---");
		System.out.println("NEW PASSWORD : " + member.getMem_password());
		System.out.println("FIND EMAIL(ID) : " + member.getMem_email());
		
		jdbcTemplate.update("UPDATE MEMBER SET MEM_PW = ? " + " WHERE MEM_ID = ? ", member.getMem_password(), member.getMem_email());
	}
	
	/*
		회원탈퇴
	*/
	public void mDelete(Member member) {
		
		System.out.println("---DELETE---");
		System.out.println("FIND EMAIL(ID) : " + member.getMem_email());
		
		jdbcTemplate.update("DELETE FROM MEMBER WHERE MEM_ID = ?",	member.getMem_email());
	}
}
