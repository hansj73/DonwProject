package com.prj.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.prj.Culture.security.dto.UserDTO;

public class PasswordCreate   {

	@Autowired 
	private static PasswordEncoder passwordEncoder; 
	
	@Autowired 
	private static SaltSource saltSource;
	
	@Autowired(required = false)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   
		
		  try 
		  { 
		      String password="test";  
		      UserDTO user =null; 
			  
		        String hashedPassword = passwordEncoder.encodePassword(password, saltSource.getSalt(user)); 
		        System.out.println(":::::hashedPassword::"+hashedPassword);
		        System.out.println("::::");
		        //logger.info("username : " + userId + " / password : " + password + " / hash password : " + hashedPassword); 
		        //logger.info("username : " + user.getUsername() + " / password : " + user.getPassword()); 
		        
		  } 
		  catch(UsernameNotFoundException e) 
		  { 
		        //throw new UsernameNotFoundException(e.getMessage());
		        System.out.println("::::UsernameNotFoundException::"+e);
		  } 
		  catch(BadCredentialsException e) 
		  { 
//		        throw new BadCredentialsException(e.getMessage()); 
		        System.out.println("::::BadCredentialsException::"+e);
		  } 
		  catch(Exception e) 
		  { 
			  System.out.println("::::Exception::"+e);
		  } 

	}

}
