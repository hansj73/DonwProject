package com.prj.Culture.security.dao;

import java.util.ArrayList;

import com.prj.Culture.member.dto.MemberDTO;

public interface LoginDao1 {

	public ArrayList<MemberDTO> getMembers(MemberDTO mem);
	
	public ArrayList<MemberDTO> getMembersInfo(String user_id);
}
