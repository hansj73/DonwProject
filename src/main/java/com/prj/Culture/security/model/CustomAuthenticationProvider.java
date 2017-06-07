package com.prj.Culture.security.model;



import java.util.Collection;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.prj.Culture.security.dto.UserDTO;
import com.prj.Culture.security.service.UserService;


public class CustomAuthenticationProvider implements AuthenticationProvider  {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	
	@Autowired(required=false)
	UserService userService; 
	
	/*@Autowired(required=false) 
	private PasswordEncoder passwordEncoder; */
	
	@Autowired (required=false)
	private SaltSource saltSource;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;



	
    
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		
		  return authentication.equals(UsernamePasswordAuthenticationToken.class);
		//return false;
	}
	
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String userId = (String)authentication.getPrincipal(); // (String)authentication.getName();
		String rawPassword = (String)authentication.getCredentials();
		
		UserDTO user; 
		Collection<? extends GrantedAuthority> authorities;
		
	

		  try 
		  { 
		        user = userService.loadUserByUsername(userId); 
//		        String hashedPassword = passwordEncoder.encodePassword(password, saltSource.getSalt(user)); 
//		        logger.info("username : " + userId + " / password : " + password + " / hash password : " + hashedPassword); 
//		        logger.info("username : " + user.getUsername() + " / password : " + user.getPassword()); 
		        System.out.println(":::::"+"username : " + userId + " / password : " + rawPassword + " / hash password : " + user.getPassword());
//		        if (!hashedPassword.equals(user.getPassword())) throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
		        String encodedPassword=(String)user.getPassword();
		     if ( !passwordEncoder.matches(rawPassword,encodedPassword) ) { throw new BadCredentialsException( "암호가 일치하지 않습니다." ); }

		        
		        authorities = user.getAuthorities(); 
		  } 
		  catch(UsernameNotFoundException e) 
		  { 
		        logger.info(e.toString()); 
		        throw new UsernameNotFoundException(e.getMessage()); 
		  } 
		  catch(BadCredentialsException e) 
		  { 
		        logger.info(e.toString()); 
		        throw new BadCredentialsException(e.getMessage()); 
		  } 
		  catch(Exception e) 
		  { 
		        logger.info(e.toString()); throw new RuntimeException(e.getMessage()); 
		  } 
		        return new UsernamePasswordAuthenticationToken(user, rawPassword, authorities); 
		
	}
}
