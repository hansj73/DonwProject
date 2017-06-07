package com.prj.Culture.security.service;

import java.util.ArrayList;
import java.util.List;







import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prj.Culture.member.dto.MemberDTO;
import com.prj.Culture.security.dto.UserDTO;
import com.prj.Culture.security.model.Role;

@Service
public class UserService implements UserDetailsService {

	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	LoginService loginDao;
	
	@Override 
	public UserDTO loadUserByUsername(final String userId) throws UsernameNotFoundException 
	{ 
	   
		ArrayList<MemberDTO> memberList = loginDao.getMembersInfo(userId); 
	  
		logger.info("userId : " + userId+":::passwordq::"); // 회원 정보 dao 에서 데이터를 읽어 옴. // test 값을 암호화함. 
	   
		  if(memberList.size()==0)
		  {
			  throw new UsernameNotFoundException("접속자 정보를 찾을 수 없습니다."); 
		  }
		  else
		  {
			/*  System.out.println("::pwd::"+memberList.get(0).getPwd()); 
			  System.out.println("::pwd::"+memberList.get(0).getUser_id());
			  System.out.println("::pwd::"+memberList.get(0).getEmail());
			  System.out.println("::pwd::"+memberList.get(0).getName());*/
			 
			  UserDTO user = new UserDTO(); 
			  user.setUsername(memberList.get(0).getName()); 
			  user.setUser_id(userId); 
			  user.setPassword(memberList.get(0).getPwd());
			  user.setEmail(memberList.get(0).getEmail());
			  Role role = new Role(); 
			  role.setName(memberList.get(0).getRole_auth()); 
			  List<Role> roles = new ArrayList<Role>(); 
			  roles.add(role); 
			  user.setAuthorities(roles);
		       
			  /*if (user == null) throw new UsernameNotFoundException("접속자 정보를 찾을 수 없습니다.");*/ 
			  // 만약 데이터가 없을 경우 익셉션 
			  return user; 
		  }
	  }

}
