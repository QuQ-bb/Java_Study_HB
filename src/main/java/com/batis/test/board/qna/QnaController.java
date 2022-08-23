package com.batis.test.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.batis.test.board.impl.BoardDTO;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	//글목록
	@RequestMapping(value="list.ms",method=RequestMethod.GET)
	public ModelAndView getList()throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> al = qnaService.getList();
		mv.setViewName("qna/list");
		mv.addObject("list", al);
		
		return mv;
	}
	//글 조회
	@RequestMapping(value="detail.ms",method=RequestMethod.POST)
	public String getDetial(BoardDTO boardDTO,Model model)throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		
		model.addAttribute("detail", boardDTO);
		
		return "qna.detail";
	}
	//글작성
	@RequestMapping(value="add.ms",method = RequestMethod.GET)
	public String setAdd()throws Exception{
		return "qna/add";
		
	}
	@RequestMapping(value="add.ms",method=RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO)throws Exception{
		int result = qnaService.setAdd(boardDTO);
		
		return "redirect:list.ms";
	}
	//글 수정
	@RequestMapping
	public ModelAndView setUpdate(BoardDTO boardDTO,ModelAndView mv)throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		
		mv.addObject("update", boardDTO);
		mv.setViewName("qna/update");
		
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
