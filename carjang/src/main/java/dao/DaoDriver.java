package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import driver.Driver;
import member.Car;
import member.Member;

public class DaoDriver {
	private JdbcTemplate jdbcTemplate;

	public DaoDriver(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/*
	 	운전자 디테일 검색
	*/
	public Driver selectById(String memId) {
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
		return results.size()>0 ? results.get(0) : null;
	}

	public void insert(final Driver driver) {

		System.out.println("---INSERT---");
		System.out.println("EMAIL : " + driver.getDrv_id());

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO DRIVER VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
					pstmt.setString(1, driver.getDrv_id());
					pstmt.setInt(2, driver.getDrv_lisc());
					pstmt.setInt(3, driver.getDrv_phone());
					pstmt.setInt(4, 0);
					pstmt.setString(5, "o");
					pstmt.setInt(6, 0);
					pstmt.setInt(7, driver.getDrv_account());
					pstmt.setString(8, driver.getDrv_bank());					
				return pstmt;
			}
		});
	}

	/*
	 * 차 검색
	 */
	public List<Car> selectById3(String memId) {
		List<Car> results = jdbcTemplate.query(
				"SELECT * FROM CAR WHERE CAR_DRV_ID = ?", new RowMapper<Car>() {
			public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
				Car car = new Car(
						rs.getString("CAR_NUM"), 
						rs.getString("CAR_DRV_ID"), 
						rs.getString("CAR_KIND"));
				return car;
			}
		}, memId);
		return results.isEmpty() ? null : results;
	}
}
