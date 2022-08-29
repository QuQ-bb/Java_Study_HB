package com.batis.test.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.batis.test.board.impl.BoardDTO;
import com.batis.test.util.Pager;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;

	@ModelAttribute("board")
	public String getQna() {
		return "qna";
	}
	@GetMapping("reply.ms")
	public ModelAndView setReply(BoardDTO boardDTO,ModelAndView mv)throws Exception{
			mv.setViewName("board/reply");
			mv.addObject("reply", boardDTO);
			return mv;
	}
	@PostMapping
	public String setReply(QnaDTO qnaDTO)throws Exception{
		int result = qnaService.setReply(qnaDTO);
		
		return "redirect:list.ms";
	}
	
	//글목록
	@RequestMapping(value="list.ms",method=RequestMethod.GET)
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> al = qnaService.getList(pager);
		mv.addObject("list", al);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
	}
	//글 조회
	@RequestMapping(value="detail.ms",method=RequestMethod.GET)
	public String getDetial(BoardDTO boardDTO,Model model)throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		
		model.addAttribute("detail", boardDTO);
		
		return "board/detail";
	}
	//글작성
	@RequestMapping(value="add.ms",method = RequestMethod.GET)
	public String setAdd(Model model)throws Exception{
		return "board/add";
		
	}
	@RequestMapping(value="add.ms",method=RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO,HttpSession session,MultipartFile[] files)throws Exception{
		int result = qnaService.setAdd(boardDTO,session.getServletContext(),files);
		session.getAttribute("member");
		
		return "redirect:list.ms";
	}
	//글 수정
	@RequestMapping
	public ModelAndView setUpdate(BoardDTO boardDTO,ModelAndView mv)throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		
		mv.addObject("update", boardDTO);
		mv.setViewName("board/update");
		
		return mv;
	}
	@RequestMapping(value="update.ms",method=RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		int result = qnaService.setUpdate(boardDTO);
		
		return "redirect:list.ms?num="+boardDTO.getNum();
	}
	@RequestMapping(value="delete.ms",method=RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO)throws Exception{
		int result = qnaService.setDelete(boardDTO);
		
		return "redirect:list.ms";
	}

}
