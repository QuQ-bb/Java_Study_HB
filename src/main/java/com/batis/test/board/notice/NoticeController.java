package com.batis.test.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.batis.test.board.impl.BoardDTO;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//글목록
	@RequestMapping(value="list.ms", method=RequestMethod.GET)
	public ModelAndView getList()throws Exception{	//매개변수 사용할때 : 주로 parameter 받아올 때
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> al = noticeService.getList();
		mv.setViewName("notice/list");
		mv.addObject("list", al);
		
		return mv;
		
	}
	
	//글 조회(상세)
	@RequestMapping(value="detail.ms", method= RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getDetail(boardDTO);
		mv.setViewName("notice/detail");
		mv.addObject("detail", boardDTO);
		
		return mv;
	}
//	  @RequestMapping(value = "detail.ms", method = RequestMethod.GET)
//	   public String getDetail(BoardDTO boardDTO, Model model)throws Exception{
//	      boardDTO = noticeService.getDetail(boardDTO);
//	      model.addAttribute("boardDTO", boardDTO);
//	      
//	      return "notice/detail";
//	   }
	
	//글 작성
	//확장자를 붙여주고 리턴 타입을 void로 사용하면 경로를 제대로 가지 못 할 수 있다. 그렇기 때문에 String으로 return 시켜주기!!
	@RequestMapping(value="add.ms", method = RequestMethod.GET)
	public String setAdd()throws Exception{
		return "notice/add";
	}
	
	@RequestMapping(value="add.ms" ,method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO)throws Exception{	//리턴타입이 void면 url이 요쳥 value와 같아진다
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setAdd(boardDTO);
		mv.setViewName("redirect:list.ms");
		
		return mv;
	}
	
	//글 수정
	@RequestMapping(value="update.ms",method= RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("update", boardDTO);
		mv.setViewName("notice/update");
		
		return mv;
	}
	
	@RequestMapping(value="update.ms", method=RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		
		return "redirect:update.ms?num="+boardDTO.getNum();
	}
	
	//글  삭제
	@RequestMapping(value="delete.ms" ,method=RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO)throws Exception{
		int result =  noticeService.setDelete(boardDTO);
		
		return "redirect:list.ms";
		
	}

}
