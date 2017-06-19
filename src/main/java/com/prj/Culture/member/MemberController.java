package com.prj.Culture.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
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
		
	@RequestMapping(value = "/member/mypage", method = RequestMethod.GET)
	public String passwd(Locale locale, Model model) {
		
		ArrayList<String> arr = new ArrayList<String>();
		String data="";
		String[] ddata;
		  try 
		  { 
			 
		  
		     Runtime rt1 = Runtime.getRuntime(); 
			 Process proc1 = rt1.exec("df -hlP --type=ext3 "); //전체용량 GB
			 InputStream is1 = proc1.getInputStream(); 
	         InputStreamReader isr1 = new InputStreamReader(is1); 
	         BufferedReader br1 = new BufferedReader(isr1);
	            String line1;
	            while((line1=br1.readLine())!= null){
	            	 arr.add(line1+"\n");
	            }
	            data=arr.get(3);
			    data=data.replaceAll("/dev/sdb1", "");
			    data=data.replaceAll("/data", "");
			    data=data.replaceAll("\\p{Z}", "");
			 //   System.out.println(data);
			    ddata=data.split("G");
		    
		   // System.out.println("::총디스크용량::"+ddata[0]+":::사용중인용량::"+ddata[1]+":::남은용량:::"+ddata[2]+"::사용%::"+ddata[3].replaceAll("%",""));
		    

		    model.addAttribute("totalSpace", ddata[0]);
	    	model.addAttribute("usedSpace", ddata[1]);
	    	model.addAttribute("usedPer",ddata[3]);
		  } 
		  catch(Exception e) 
		  { 
		        //throw new UsernameNotFoundException(e.getMessage());
			  System.out.println(e);
		      
		  } 
      

		return "/member/mypage";
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
		
		return "/member/mypage";
	}
	
	
	@RequestMapping(value = "/member/passwd", method = RequestMethod.GET)
	public String passwd1(Locale locale, Model model) {
		
		ArrayList<String> arr = new ArrayList<String>();
		String data="";
		String[] ddata;
		try 
		  { 
			  
		 //System.out.println("::::disk call::::");

		 Runtime rt1 = Runtime.getRuntime(); 
		 Process proc1 = rt1.exec("df -hlP --type=ext3 "); //전체용량 GB
		 InputStream is1 = proc1.getInputStream(); 
         InputStreamReader isr1 = new InputStreamReader(is1); 
         BufferedReader br1 = new BufferedReader(isr1);
            String line1;
            while((line1=br1.readLine())!= null){
            	 arr.add(line1+"\n");
            }
            data=arr.get(3);
		    data=data.replaceAll("/dev/sdb1", "");
		    data=data.replaceAll("/data", "");
		    data=data.replaceAll("\\p{Z}", "");
		    //System.out.println(data);
		    ddata=data.split("G");
		    
		    System.out.println("::총디스크용량::"+ddata[0]+":::사용중인용량::"+ddata[1]+":::남은용량:::"+ddata[2]+"::사용%::"+ddata[3]);   
	            
		  }catch(Exception e){
		  }
		

		return "/member/passwd";
	}

	
}
