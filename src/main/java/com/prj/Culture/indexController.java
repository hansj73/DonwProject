package com.prj.Culture;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class indexController {
	
	private static final Logger logger = LoggerFactory.getLogger(indexController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping({"/","/index.do"})
	public String index(Locale locale, Model model) {
		return "index";
	}
	@RequestMapping({"/main.do"})
	public String main(Locale locale, Model model) {
		return "main";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String singin(HttpServletRequest request,@RequestParam(value="error", required=false) String error, Model model) {
		
		/*HttpSession session = request.getSession();
		String referrer="";
		if(session ==null)
		{
				//referrer = request.getHeader("Referer");
			   referrer="/board/list.do";
				request.getSession().setAttribute("prevPage", referrer);
				System.out.println(":::referrer:::"+referrer);
		}*/
		 /*System.out.println("::::session_prevPage:::"+session.getAttribute("prevPage"));*/
		
		/*Authentication auth= SecurityContextHolder.getContext().getAuthentication();*/
		 
	    model.addAttribute("error", error);

		return "login";
	}
	
	@RequestMapping(value = "/loginFail", method = RequestMethod.GET)
	public String singinfail(@RequestParam(value="error", required=false) String error, Model model){

	   System.out.println(":::;loginFail::");
		return "denied";
	}
	
	@PreAuthorize("authenticated")
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String myPage(Model model) {
		
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		
		model.addAttribute("user_name",auth.getName());
		return "mypage";
	}
	
	@RequestMapping(value="/denied",method=RequestMethod.GET)
	public String denied() {
		return "denied";
		
	}
}
