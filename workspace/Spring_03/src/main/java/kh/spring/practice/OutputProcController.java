package kh.spring.practice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kh.spring.dao.MessageDAO;
import kh.spring.dto.MessageDTO;

public class OutputProcController implements Controller{
	
	@Autowired
	private MessageDAO mdao;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		ModelAndView mav = new ModelAndView();
		
		try {
			List<MessageDTO> lists = mdao.select();
			mav.addObject("lists", lists);
			mav.setViewName("WEB-INF/output/output.jsp");
			return mav;
		}catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:error.do");
			return mav;
		}
	}
}
