package com.prj.Culture.board.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.Culture.board.dao.BoardDao;
import com.prj.Culture.board.dto.BoardDTO;


@Service
public class BoardService  {
	
	@Autowired
	private BoardDao boardDao;

	public ArrayList<BoardDTO> getList(Map<String, Object> map) {
	
		ArrayList<BoardDTO> result = new ArrayList<BoardDTO>();
		result = boardDao.getList(map);
		return result;
	}

	
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (Integer)boardDao.getRowCount(map);
	}

	
	public void insertBoard(BoardDTO boardWrite) {
		// TODO Auto-generated method stub
		
		boardDao.insertBoard(boardWrite);
	}
	public BoardDTO viewBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		//boardMapper.viewBoard(seq);
		return boardDao.viewBoard(map);
	}
	
	public void updateHit(int seq) {
		// TODO Auto-generated method stub
		boardDao.updateHit(seq);
	}
	
	public void deleteBoard(int seq) {
		// TODO Auto-generated method stub
		
		boardDao.deleteBoard(seq);
	}
	
	public void editBoard(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		boardDao.editBoard(boardDto);
		
	}

}
