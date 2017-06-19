package com.prj.Culture.board.dao;

import java.util.ArrayList;
import java.util.Map;

import com.prj.Culture.board.dto.BoardDTO;

public interface BoardMapper {

	public ArrayList<BoardDTO> getList(Map<String,Object> map);
	 
	public int getRowCount(Map<String,Object> map);
	
	public void insertBoard(BoardDTO boardWrite); 
	
	public BoardDTO viewBoard(Map<String,Object> map);
	
	public void updateHit(int seq);
	
	public void deleteBoard(int seq);
	
	public void editBoard(BoardDTO boardDto);
}
