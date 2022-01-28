package com.hgu.webcamp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hgu.webcamp.DTO.userDTO;
import com.hgu.webcamp.Service.userService;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")

public class TeamProject_Controller {

	@Autowired
	userService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
	public String teamProject_index(Model model) {
		
		System.out.println("index page loaded");
		
		return "/index";
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public ModelAndView teamProject_myPage(HttpServletRequest request) {
		
		userDTO dto = new userDTO();
		
		int id = ((userDTO)request.getSession().getAttribute("tempUser")).getId();
	
		dto=userService.getUser(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("info", dto);
		mv.setViewName("/myPage");
		
		System.out.println("my page loaded");
		
		return mv;
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView teamProject_register(Model model) {
		
		List<userDTO> mbtiList = userService.readAllMbti();
//		for(userDTO mbti : mbtiList) {
//			System.out.println(mbti.toString());
//		}
		System.out.println("register page loaded");
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("mbtiList", mbtiList);
		mv.setViewName("/register");
		
		return mv;
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView teamProject_login(ModelAndView model, HttpServletRequest request) {
		if(request.getSession().getAttribute("tempUser") != null) {
			userDTO u = new userDTO();
			u = (userDTO) request.getSession().getAttribute("tempUser");
			//�쉶�썝 �젙蹂닿� �뾾�뒗 寃쎌슦
			if(userService.readUserByEmail(u.getEmail())==0) {
				model.setViewName("redirect:/register");
				return model;
			}
			//�쉶�썝 �젙蹂닿� �엳�뒗 寃쎌슦
			
			model.setViewName("redirect:/index");
			return model;
		}
		//System.out.println(userName);
		System.out.println("login loaded");
		
		model.setViewName("login");
		return model;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/alert", method = RequestMethod.GET)
	public String teamProject_alert(ModelAndView model, HttpServletRequest request) {
		
//		String msg = (String)request.getAttribute("msg");
//		String url = (String)request.getAttribute("url");
//		
		System.out.println("alert page loaded");

		
		return "/alert";
	}

}
