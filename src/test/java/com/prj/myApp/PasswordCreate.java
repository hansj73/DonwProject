package com.prj.myApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class PasswordCreate   {


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   
		ArrayList<String> arr = new ArrayList<String>();
		String data="";
		String[] ddata;
		  try 
		  { 
			 
			  
			  BufferedReader in = new BufferedReader(new FileReader("G:/study/workspace/DownProject/src/test/java/com/prj/myApp/a.txt"));
		      String s="";

		      while ((s = in.readLine()) != null) {
		    	  //System.out.println(s);
		    	  arr.add(s+"\n");
		      }
		      
		    System.out.println(arr.get(3));
		    data=arr.get(3);
		    data=data.replaceAll("/dev/sdb1", "");
		    data=data.replaceAll("/data", "");
		    data=data.replaceAll("\\p{Z}", "");
		    System.out.println(data);
		    ddata=data.split("G");
		    
		    System.out.println("::총디스크용량::"+ddata[0]+":::사용중인용량::"+ddata[1]+":::남은용량:::"+ddata[2]+"::사용%::"+ddata[3]);
		    

		  } 
		  catch(Exception e) 
		  { 
		        //throw new UsernameNotFoundException(e.getMessage());
			  System.out.println(e);
		      
		  } 
		  	}

}
