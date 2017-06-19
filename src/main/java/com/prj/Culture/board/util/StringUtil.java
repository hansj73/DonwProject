package com.prj.Culture.board.util;

public class StringUtil {
	
	  public StringUtil() {}
	
	 public static String parseBr(String msg){
	        
	        if(msg == null) return null;
	        
	        return msg.replace("\r\n", "<br>")
	                  .replace("\n", "<br>");
	    }
	 
	 public static String NulltoString(String msg){
	        
	        if(msg == null){ 
	        	return "";
	        }else{
	        	return msg;
	        }
	    }
}
