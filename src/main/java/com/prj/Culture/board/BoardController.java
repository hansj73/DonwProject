package com.prj.Culture.board;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	  private int pageSize = 10;
	  private int blockCount = 10;
	
	@Autowired
	private BoardService boardDao;
	
	@Resource(name="downloadView")
    private View downloadView;
	
	
	UploadedFile ufile = new UploadedFile();
	
	@RequestMapping(value = "/board/list")
	public ModelAndView  list(@RequestParam(value="pageNum",defaultValue="1")int currentPage,
							  @RequestParam(value="keyField",defaultValue="")String keyField,
							  @RequestParam(value="keyWord",defaultValue="")String keyWord){
	
		logger.info("[start]---list----");
		
		  String pagingHtml = "";
		  
		  if(logger.isDebugEnabled()){
			  logger.debug("currentPage : " + currentPage);
			  logger.debug("keyField : " + keyField);
			  logger.debug("keyWord : " + keyWord);
	        }
	
		  HashMap<String, Object> map = new HashMap<String, Object>();
	        map.put("keyField", keyField);
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
        
		return mv;
	}

	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write_form() {
		return "/board/write";
	}
	
	 @RequestMapping(value = "/board/fileUpload", method = RequestMethod.POST)
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
	        File file = new File(FileUtil.UPLOAD_PATH+"/"+newName);
	        System.out.println(":::file::"+file);
	        mpf.transferTo(file);
	     
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return newName;
	
	 
	  }
	 
	@RequestMapping(value = "/board/write_ok", method = RequestMethod.POST)
	public String submit(BoardDTO boardDto, Model model){
		
		 try{
	            
	            boardDao.insertBoard(boardDto);
	        
	        }catch(Exception e){
	            e.printStackTrace();
	        }
		 return "redirect:/board/list.do";
	}
	
	@RequestMapping(value = "/board/view/{seq}")
	/*public ModelAndView view(@RequestParam("seq")int seq) {*/
		public ModelAndView view(@PathVariable int seq) {
		
		if(logger.isDebugEnabled()){
			logger.debug("seq : " + seq);
        }
		
		logger.info("seq : " + seq);
		
		boardDao.updateHit(seq);
		logger.info("updateHit : " + seq);

		BoardDTO viewDto = boardDao.viewBoard(seq);
 
        viewDto.setContent(StringUtil.parseBr(viewDto.getContent()));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/view");
		mv.addObject("boardView",viewDto);
		
		return mv;
	}
	
	//파일 다운로드
    @RequestMapping("/board/file.do")
    public ModelAndView download(@RequestParam("filename")String filename,@RequestParam("realname")String realname)throws Exception{

        File downloadFile = new File(FileUtil.UPLOAD_PATH + "/" + filename);
        	 
        
         ModelAndView mv = new ModelAndView();
        mv.addObject("downloadFile",downloadFile );
        mv.addObject("realname",realname );
        mv.setView(downloadView);
        
//        return new ModelAndView(downloadView,"downloadFile",downloadFile);
        return mv;
        
    }
    
    
    @RequestMapping(value = "/board/delete", method = RequestMethod.POST)
    public String delete(BoardDTO boardDto, Model model) {
    	
    	int seq = boardDto.getSeq();
    	
    	/** 업로드 파일 있을시에 파일 삭제 ***/
    	
    	if(boardDto.getFilename()!=null){
    		FileUtil.removeFile(boardDto.getFilename());
    	}
    	
    	boardDao.deleteBoard(seq);
    	
        return "redirect:/board/list.do";
    }
    
    @RequestMapping(value = "/board/edit/{seq}")
    public ModelAndView edit(@PathVariable int seq){
       BoardDTO boardDto = boardDao.viewBoard(seq);
        return new ModelAndView("/board/edit","boardView",boardDto);
    }
    
    @RequestMapping(value = "/board/edit_ok", method = RequestMethod.POST)
	public String editOk(BoardDTO boardDto, Model model){
		
    	logger.info("::[start]:edit_ok::");
    	
    	 String oldFileName = boardDto.getOldFileName();
    	 
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
		 
    	 System.out.println("::::::boardDto.getFilename():::::"+boardDto.getFilename());
		 
		 if(!"".equals(boardDto.getFilename())){
			 if(oldFileName != null){
                 //이전파일 삭제 
                 FileUtil.removeFile(oldFileName);
             }
         }else{
        	 boardDto.setFilename(oldFileName);//파일명
         }
		
		 boardDao.editBoard(boardDto);
		 
		 logger.info("::[end]:edit_ok::");
		 return "redirect:/board/list.do";
	}
    
}
