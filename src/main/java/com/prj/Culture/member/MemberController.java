package com.prj.Culture.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.prj.Culture.security.dto.UserDTO;
import com.prj.Culture.security.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	


	 
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/member/passwd", method = RequestMethod.GET)
	public String passwd(Locale locale, Model model) {
		
		return "/member/passwd";
	}
	
	@RequestMapping(value = "/member/passwd_ok", method = RequestMethod.POST)
	public String passwd_ok(@RequestParam("password")String password, Model model) {
	 
		 String hashedPassword="";
		 System.out.println(":::password::"+password);
		try 
		  { 
//		        user = userService.loadUserByUsername(userId); 
			
			hashedPassword=passwordEncoder.encode(password);
		        
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
			  logger.info(e.toString()); 
		  } 
		
        
		model.addAttribute("passwd", hashedPassword );
		
		return "/member/passwd";
	}
	
}
