package com.prj.Culture.board.util;

import java.io.File;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class FileUtil {

	 //업로드 경로
	
    /**
     * 파일 이름 변경, 변경할 이름을 메소드내에서 지정
     * */
    //public static final String UPLOAD_PATH="";
    
    public static String rename(String filename) throws Exception{
        
        if(filename ==null) return null;
        String newName = Long.toString(System.currentTimeMillis())+(int)(Math.random()*50);
        
        return rename(filename, newName);
    }
    /**
     * 파일 이름 변경, 변경할 이름을 메소드 호출할 때마다 지정 가능
     * */
    public static String rename(String filename, String newName)throws Exception{
        
        if(filename == null) return null;
 
        //파일명을 원하는 형식으로 변경하기
        int idx = filename.lastIndexOf(".");
        String extention = "";
        String newFileName = "";
 
        if(idx != -1) {
            extention = filename.substring(idx);
        }
        // 확장자를 제외한 새 파일명을 입력해야 하는데 확장자를 포함해서
        // 입력했다면 확장자를 제외하고 파일명으로 셋팅
        int newIdx = newName.lastIndexOf(".");
        if(newIdx !=-1){
            newName = newName.substring(0,newIdx);
        }
 
        newFileName = newName + extention.toLowerCase();
        
        return newFileName;
    }
    /**
     * 파일 삭제
     * */
    public static void removeFile(String UPLOAD_PATH,String filename){
        File file = new File(UPLOAD_PATH,filename);
        if(file.exists()) file.delete();
        
    }
}
