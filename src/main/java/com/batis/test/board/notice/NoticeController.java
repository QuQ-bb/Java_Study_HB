package com.batis.test.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.batis.test.bankMembers.BankMembersDTO;
import com.batis.test.board.impl.BoardDTO;
import com.batis.test.util.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	
	//글목록
	@RequestMapping(value="list.ms", method=RequestMethod.GET)
	public ModelAndView getList(Pager pager)throws Exception{	//매개변수 사용할때 : 주로 parameter 받아올 때
		ModelAndView mv = new ModelAndView();
		System.out.println("시발 페이지 졸려 아 = "+pager.getPage());
		
//		System.out.println("page =="+pager.getPage());
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		
		List<BoardDTO> al = noticeService.getList(pager);
		mv.addObject("list", al);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		return mv;
		
	}
	
	//글 조회(상세)
	@RequestMapping(value="detail.ms", method= RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getDetail(boardDTO);
		mv.setViewName("board/detail");
		mv.addObject("detail", boardDTO);
		System.out.println(boardDTO);
		
		
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
	public String setAdd(HttpSession session)throws Exception{
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		if(bankMembersDTO != null) {
			return "board/add";
		}else {
			return "redirect:../login.ms";
		}
	}
	
	@RequestMapping(value="add.ms" ,method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO,HttpSession session, MultipartFile [] files)throws Exception{	//리턴타입이 void면 url이 요쳥 value와 같아진다
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setAdd(boardDTO,session.getServletContext(),files);
//		mv.setViewName("redirect:list.ms");
		session.getAttribute("member");
		
	
		String message = "글쓰기 실패";
		if(boardDTO != null) {
			message ="글쓰기 성공";
		}
		mv.addObject("result", result);
		mv.addObject("message", message);
		mv.addObject("url", "./list.ms");
		mv.setViewName("common/result");
		
		
		return mv;
	}
	
	//글 수정
	@RequestMapping(value="update.ms",method= RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("update", boardDTO);
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@RequestMapping(value="update.ms", method=RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		
		return "redirect:detail.ms?num="+boardDTO.getNum();
	}
	
	//글  삭제
	@RequestMapping(value="delete.ms" ,method=RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO)throws Exception{
		int result =  noticeService.setDelete(boardDTO);
		
		return "redirect:list.ms";
		
	}

}
