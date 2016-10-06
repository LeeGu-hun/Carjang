package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.Board;
import board.BoardInsert;
import board.BoardSearch;
import model.BoardListService;
import model.BoardRegisterService;

@Controller
public class BoardController {

	private BoardListService boardListSvc;
	private BoardRegisterService boardRegisterSvc;

	public void setBoardListService(BoardListService boardListSvc) {
		this.boardListSvc = boardListSvc;
	}
	
	public void setBoardRegisterService(BoardRegisterService boardRegisterSvc) {
		this.boardRegisterSvc = boardRegisterSvc;
	}

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Model model) {
		model.addAttribute("page", "board");
		return "main";
	}

	@RequestMapping(value = "/board/search", method = RequestMethod.POST)
	public String boardSearch(Model model, BoardSearch boardSearch) {

		List boardList = boardListSvc.getBoardList(boardSearch);
		
		model.addAttribute("board_list", boardList);
		model.addAttribute("page", "board");
		return "main";
	}

	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public String boardRegister(@RequestParam(value = "pickup_chk", defaultValue = "0") int pickup, 
			Model model, BoardInsert boardInsert) {
		
		boardInsert.setBoard_drvId("a@a.com");
		boardInsert.setBoard_pickup(pickup);
		boardRegisterSvc.regist(boardInsert);
		model.addAttribute("page", "board");
		return "main";
	}

}