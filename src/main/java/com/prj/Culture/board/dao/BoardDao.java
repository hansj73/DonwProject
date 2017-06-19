package com.prj.Culture.board.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prj.Culture.board.dto.BoardDTO;


@Repository
public class BoardDao implements BoardMapper {
	
	@Autowired
	private SqlSession sqlSession;

	
	@Override
	public ArrayList<BoardDTO> getList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<BoardDTO> result = new ArrayList<BoardDTO>();
		//getMember()의 메소드명과 mapper.mxl과 id는 동일해야한다.
		result = boardMapper.getList(map);
		return result;
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		return (Integer)boardMapper.getRowCount(map);
	}

	@Override
	public void insertBoard(BoardDTO boardWrite) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.insertBoard(boardWrite);
	}

	@Override
	public BoardDTO viewBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		//boardMapper.viewBoard(seq);
		return boardMapper.viewBoard(map);
	}

	@Override
	public void updateHit(int seq) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.updateHit(seq);
	}

	@Override
	public void deleteBoard(int seq) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.deleteBoard(seq);
	}

	@Override
	public void editBoard(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		boardMapper.editBoard(boardDto);
		
	}

}
