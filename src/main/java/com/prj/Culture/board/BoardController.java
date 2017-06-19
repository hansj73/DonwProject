package com.prj.Culture.board;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.prj.Culture.board.dto.BoardDTO;
import com.prj.Culture.board.dto.UploadedFile;
import com.prj.Culture.board.service.BoardService;
import com.prj.Culture.board.util.FileUtil;
import com.prj.Culture.board.util.PagingUtil;
import com.prj.Culture.board.util.StringUtil;

import java.util.Properties;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	

	
	/*@Resource(name="config")
    private  Properties config;
  
    public  String getFromConfig(String key) {
        return config.getProperty(key);
    }*/
    
    @Value("#{config['UploadDir']}")
    private String UPLOAD_PATH;

    
   /* public  String UPLOAD_PATH = getFromConfig("UploadDir");*/
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	  private int pageSize = 10;
	  private int blockCount = 5;
	
	@Autowired
	private BoardService boardDao;
	
	@Resource(name="downloadView")
    private View downloadView;
	
	
	UploadedFile ufile = new UploadedFile();
	
	@RequestMapping(value = "/list")
	public ModelAndView  list(@RequestParam(value="pageNum",defaultValue="1")int currentPage,
							  @RequestParam(value="keyField",defaultValue="")String keyField,
							  @RequestParam(value="keyWord",defaultValue="")String keyWord) throws UnsupportedEncodingException{
	
		logger.info("[start]---list----");
		
		  String pagingHtml = "";
		  
		  if(logger.isDebugEnabled()){
			  logger.debug("currentPage : " + currentPage);
			  logger.debug("keyField : " + keyField);
			  logger.debug("keyWord : " + keyWord);
	        }
	
		  HashMap<String, Object> map = new HashMap<String, Object>();
	        map.put("keyField",  keyField);
	        map.put("keyWord", keyWord);
		
	    int count= boardDao.getRowCount(map);
	        
	    PagingUtil page = new PagingUtil(keyField, keyWord, currentPage, count, pageSize, blockCount, "/board/list.do");
	    
	    pagingHtml = page.getPagingHtml().toString();
	    
	    map.put("start", page.getStartCount());
        map.put("end", page.getEndCount());
        
        
        List<BoardDTO> list = null;
        
        if(count >0){
        	list=boardDao.getList(map);
        }else{
        	list= Collections.emptyList();
        }
		
        int number = count-(currentPage-1)*pageSize;
        
        ModelAndView mv= new ModelAndView();
        mv.setViewName("/board/list");
        mv.addObject("count", count);
        mv.addObject("boardlist", list);
        mv.addObject("pagingHtml", pagingHtml);
        mv.addObject("number", number);
        
        mv.addObject("keyWord", keyWord);
        mv.addObject("keyField", keyField);
        
		return mv;
	}

	
	@RequestMapping(value = "/write")
	public String write_form(HttpServletRequest request, HttpServletResponse response,
			 @RequestParam(value="title",required=false) String title,
			 @RequestParam(value="content",required=false) String content,
			Model model) {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      Calendar c1 = Calendar.getInstance();
		  String strToday = sdf.format(c1.getTime());
		  
		  
		  content=StringUtil.NulltoString(content);
		  title=StringUtil.NulltoString(title);
		  
		  //content=(!"".equals(content))?StringUtil.parseBr(content):content;
		  
		  model.addAttribute("strToday", strToday );
		  model.addAttribute("title",title);
		  model.addAttribute("content",content);
		  return "/board/write";
	}
	
	 @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	   public @ResponseBody String upload(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {                 
	 
	     //0. notice, we have used MultipartHttpServletRequest
	 
	     //1. get the files from the request object
	     Iterator<String> itr =  request.getFileNames();
	 
	     MultipartFile mpf = request.getFile(itr.next());
	     System.out.println(mpf.getOriginalFilename() +" uploaded!");
	     String newName="";
	     BoardDTO boardDto  = new BoardDTO();
	     try {
	                //just temporary save file info into ufile
	        ufile.length = mpf.getBytes().length;
	        ufile.bytes= mpf.getBytes();
	        ufile.type = mpf.getContentType();
	        ufile.name = mpf.getOriginalFilename();
	        newName = FileUtil.rename(ufile.name);
	        boardDto.setOldFileName(newName);
	      /*  System.out.println(":::ufile.length::"+ufile.length);
	        System.out.println(":::ufile.bytes::"+ufile.bytes);
	        System.out.println(":::ufile.type::"+ufile.type);
	        System.out.println(":::ufile.name::"+ufile.name);
	        System.out.println(":::newName::"+newName);*/
//	        File file = new File(FileUtil.UPLOAD_PATH+"/"+newName);
	        File file = new File(UPLOAD_PATH+"/"+newName);
	       
	        mpf.transferTo(file);
	     
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return newName;
	
	 
	  }
	 
	@RequestMapping(value = "/write_ok", method = RequestMethod.POST)
	public String submit(BoardDTO boardDto, Model model){
		
		 try{
	            boardDao.insertBoard(boardDto);
	        }catch(Exception e){
	         	e.printStackTrace();
	        }
		 return "redirect:/board/list.do";
	}
	
	@RequestMapping(value = "/view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) {
		/*public ModelAndView view(@PathVariable int seq) {*/
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		   map.put("seq", seq);
		   map.put("keyField", keyField);
	       map.put("keyWord", keyWord);
		
		if(logger.isDebugEnabled()){
			logger.debug("seq : " + seq);
        }
		
		/*System.out.println("seq : " + seq);
		System.out.println("keyField : " + keyField);
		System.out.println("keyWord" + seq);*/
		
		logger.info("seq : " + seq);
		
		boardDao.updateHit(seq);
		logger.info("updateHit : " + seq);

		BoardDTO viewDto = boardDao.viewBoard(map);
 
        viewDto.setContent(StringUtil.parseBr(viewDto.getContent()));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/view");
		mv.addObject("boardView",viewDto);
		mv.addObject("keyField",keyField);
		mv.addObject("keyWord",keyWord);
		
		return mv;
	}
	
	//파일 다운로드
    @RequestMapping("/file.do")
    public ModelAndView download(@RequestParam("filename")String filename,@RequestParam("realname")String realname)throws Exception{

        /*File downloadFile = new File(FileUtil.UPLOAD_PATH + "/" + filename);*/
        File downloadFile = new File(UPLOAD_PATH + "/" + filename);
        	 
        
        ModelAndView mv = new ModelAndView();
        mv.addObject("downloadFile",downloadFile );
        mv.addObject("realname",realname );
        mv.setView(downloadView);
        
//        return new ModelAndView(downloadView,"downloadFile",downloadFile);
        return mv;
        
    }
    
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, Model model) {
    	
    	 int seq = Integer.parseInt(request.getParameter("seq"));
    	 String delFileName = StringUtil.NulltoString(request.getParameter("delFileName"));
    	/** 업로드 파일 있을시에 파일 삭제 ***/
  
    	
    	if(!"".equals(delFileName)){
    		FileUtil.removeFile(UPLOAD_PATH,delFileName);
    	}
    	
    	boardDao.deleteBoard(seq);
   
        return "redirect:/board/list.do";
    }
    
    @RequestMapping(value = "/multiDel", method = RequestMethod.POST)
    public @ResponseBody String listdel(HttpServletRequest request,
    	      HttpServletResponse response,
    	      @RequestParam(value="seq",required=false) List<String> delChk,
    	      @RequestParam(value="delFileName",required=false) List<String> delFileName, Model model) {
    	
    	int i = 0;
        for( String value : delChk ){
          System.out.println( ">>> name's value : " + value + "delFileName : " + delFileName.get(i) );
          
          if(!"".equals(delFileName.get(i))){
        	  FileUtil.removeFile(UPLOAD_PATH,delFileName.get(i));
          }
          boardDao.deleteBoard(Integer.parseInt(value));
          
          i++;
        }
    	
  
    	
    	/*if(!"".equals(delFileName)){
    		FileUtil.removeFile(delFileName);
    	}
    	
    	boardDao.deleteBoard(seq);
   */
        //return "redirect:/board/list.do";
        return "success";
    }
    
    @RequestMapping(value = "/edit/{seq}")
    public ModelAndView edit(@PathVariable int seq){
    	HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
       BoardDTO boardDto = boardDao.viewBoard(map);
        return new ModelAndView("/board/edit","boardView",boardDto);
    }
    
    @RequestMapping(value = "/edit_ok", method = RequestMethod.POST)
	public String editOk(BoardDTO boardDto,HttpServletRequest request,
  	      HttpServletResponse response, Model model){
		
    	logger.info("::[start]:edit_ok::");
    	
    	 String oldFileName = boardDto.getOldFileName();
    	 String oldRealFileName = StringUtil.NulltoString(request.getParameter("oldRealFileName"));
    	 
		/* try{
	            String newName = "";
	            if(!boardDto.getUpload().isEmpty()){
	                newName = FileUtil.rename(boardDto.getUpload().getOriginalFilename());
	                boardDto.setFilename(newName);//파일명
	            }
	            
	            if(!boardDto.getUpload().isEmpty()){
	                File file = new File(FileUtil.UPLOAD_PATH+"/"+newName);
	                //원하는 경로에 파일 저장
	                boardDto.getUpload().transferTo(file);
	            }
	        }catch(IOException e){
	            e.printStackTrace();
	        }catch(Exception e){
	            e.printStackTrace();
	        }*/
		 
    	/* System.out.println("::::::boardDto.getFilename():::::"+boardDto.getFilename());*/
		 
		 if(!"".equals(boardDto.getFilename())){
			 if(oldFileName != null){
                 //이전파일 삭제 
                 FileUtil.removeFile(UPLOAD_PATH,oldFileName);
             }
         }else{
        	 boardDto.setFilename(oldFileName);//파일명
        	 boardDto.setRealname(oldRealFileName);//파일명
         }
		
		 boardDao.editBoard(boardDto);
		 
		 logger.info("::[end]:edit_ok::");
		 return "redirect:/board/list.do";
	}
    
}
