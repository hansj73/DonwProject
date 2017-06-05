package com.prj.Culture.security.dao;

import java.util.ArrayList;

import com.prj.Culture.member.dto.MemberDTO;


public interface LoginMapper {

	ArrayList<MemberDTO> getMembers(MemberDTO mem);
	
	ArrayList<MemberDTO> getMembersInfo(String user_id);
}
