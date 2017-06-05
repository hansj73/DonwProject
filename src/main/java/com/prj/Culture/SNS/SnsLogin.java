package com.prj.Culture.SNS;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SnsLogin {

	private static final Logger logger = LoggerFactory.getLogger(SnsLogin.class);
	
		
	//String key="593021632704-ps41p3s66gjqrfrpcsbqcie5vkk93ge0.apps.googleusercontent.com";
	//String passwd="H0z4tXvx3FCTlt2AvXyK-b1o";
	
	
	@RequestMapping(value = "/sns", method = RequestMethod.GET)
	public String sns(Locale locale, Model model) {
		
		return "sns1";
		
	}
	@RequestMapping(value = "/authCallBack", method = RequestMethod.GET)
	public String callBack(Locale locale, Model model) {
		
		return "home";
		
	}
}
