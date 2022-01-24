package com.hgu.webcamp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hgu.webcamp.DTO.UserDTO;
import com.hgu.webcamp.User.*;

/**
 * Handles requests for the application board.
 */
@Controller
public class User_Controller {
	
	@Autowired
	UserServiceImpl service;
	
//	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	 @RequestMapping(value="/loginOk", method=RequestMethod.POST)
	   public String loginCheck(HttpSession session, UserDTO dto) {
	      String returnURL = "";
	      if(session.getAttribute("login") != null) {
	         session.removeAttribute("login");
	      }
	      
	      UserDTO logindto = service.getUser(dto);
	      if ( logindto != null ) {
	         System.out.println("로그인 성공!");
	         session.setAttribute("login", logindto);
	         returnURL = "redirect:/board/list";
	      } else {
	         System.out.println("로그인 실패!");
	         returnURL = "redirect:/login/login";
	      }
	      return returnURL;
	   }
	 
	 @RequestMapping(value="/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/login/login";
	 }

}
