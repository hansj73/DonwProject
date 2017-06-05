package com.prj.Culture.security.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prj.Culture.member.dto.MemberDTO;

@Repository
public class LoginDao implements LoginMapper{

	@Autowired
	private SqlSession sqlSession;
	
	
	public ArrayList<MemberDTO> getMembers(MemberDTO mem){
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		LoginMapper memberMapper = sqlSession.getMapper(LoginMapper.class);
		//getMember()의 메소드명과 mapper.mxl과 id는 동일해야한다.
		result = memberMapper.getMembers(mem);
		
		return result;
	}
	
	public ArrayList<MemberDTO> getMembersInfo(String user_id){
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		LoginMapper memberMapper = sqlSession.getMapper(LoginMapper.class);
		//getMember()의 메소드명과 mapper.mxl과 id는 동일해야한다.
		result = memberMapper.getMembersInfo(user_id);
		
		return result;
	}
	
}
