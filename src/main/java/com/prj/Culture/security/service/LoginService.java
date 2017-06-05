package com.prj.Culture.security.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.Culture.member.dto.MemberDTO;
import com.prj.Culture.security.dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;
	
	
	public ArrayList<MemberDTO> getMembers(MemberDTO mem){
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		result = loginDao.getMembers(mem);
		
		return result;
	}
	
	public ArrayList<MemberDTO> getMembersInfo(String user_id){
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		result = loginDao.getMembersInfo(user_id);
		return result;
	}
	
}
