package model;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import board.Board;
import board.BoardInsert;
import dao.DaoBoard;
import exception.AlreadyExistingMemberException;

public class BoardRegisterService {
	private DaoBoard daoBoard;
	
	public BoardRegisterService(DaoBoard daoBoard) {
		this.daoBoard = daoBoard;
	}

	@Transactional
	public void regist(BoardInsert boardInsert) {
		daoBoard.insert(boardInsert);
	}
	
}