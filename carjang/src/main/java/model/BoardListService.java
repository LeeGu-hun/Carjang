package model;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import board.BoardSearch;
import dao.DaoBoard;

public class BoardListService {
	private DaoBoard daoBoard;

	public BoardListService(DaoBoard daoBoard) {
		this.daoBoard = daoBoard;
	}

	public List getBoardList(BoardSearch boardSearch) {
		List list = null;
		try {
			list = daoBoard.getBoardList(boardSearch.getBoard_loc(),
					boardSearch.getBoard_date1() + " " + boardSearch.getBoard_time1(),
					boardSearch.getBoard_date2() + " " + boardSearch.getBoard_time2(), 
					boardSearch.getBoard_price1(),boardSearch.getBoard_price2());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
/*	public int getListCount(long host_id){
		int listCount = daoBoard.getListCount(host_id);
		return listCount;
	}*/
	
}
