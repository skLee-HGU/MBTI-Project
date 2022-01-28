package com.hgu.webcamp;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hgu.webcamp.DTO.commentDTO;
import com.hgu.webcamp.DTO.questionDTO;
import com.hgu.webcamp.DTO.userDTO;
import com.hgu.webcamp.Service.*;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/teamA")
public class TeamA_Controller {

	@Autowired
	questionService questionService;
	
	@Autowired
	userService userService;
	
	@Autowired
	commentService commentService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public ModelAndView teamA_start(Model model) {

		ModelAndView mv = new ModelAndView();
		System.out.println("start page loaded");
		
		int testId = 1;
		int views = 0;
		
		views = userService.readViews(testId);

		mv.addObject("views", views);
		mv.setViewName("teamA/start");
		return mv;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public ModelAndView teamA_question(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("question page loaded");
		
		
		int questionNum= 1; // question 테이블에서 문제 
		int questionId = 1; // answer 테이블에서 문제 
		int testId = 1; // 테스트이름
		
		List<questionDTO> question = questionService.readQuestionAndAnswer(testId, questionNum, questionId);
		userService.updateViews(testId);
		
		mv.addObject("questions", question);		
		mv.setViewName("teamA/question");
		
		System.out.println(mv);
		return mv;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/question/1", method = RequestMethod.GET)
	public String teamA_question_1(Model model) {

		System.out.println("question page loaded");
		
		int testId = 1;
		userService.updateViews(testId);
		
		return "teamA/question/1";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/loading", method = RequestMethod.GET)
	public String teamA_loading(Model model) {
		
		System.out.println("loading page loaded");
		
		return "teamA/loading";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView teamA_result(Model model, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		System.out.println("result page loaded");
		
		int testId = 1;
		if(request.getSession().getAttribute("tempUser") != null) {
			int userId = ((userDTO)request.getSession().getAttribute("tempUser")).getId();
			mv.addObject("userId", userId);
		}
		

		List<commentDTO> comment = new ArrayList<commentDTO>();

		comment = commentService.getCommentList(testId);
		
		int count = comment.size();
		
		mv.addObject("comments",comment);
		mv.addObject("count", count);
		mv.setViewName("teamA/result/ENTP");
		
		System.out.println(mv);

		return mv;
	}
	*/
	// ajax로 값을 주고받는 Controller 
	@RequestMapping(value = "/ajax", method = RequestMethod.POST)
	public @ResponseBody List<questionDTO> ajax_question(@RequestParam("questionNum") int questionNum) {
						
		int testId = 1;
		int questionId = 1;
		// ajax로부터 받은 문제 번호를 1증가 시키고 questionId에도 해당 값 부여   
		questionNum++;
		questionId = questionNum;
		
		
		// 데이터베이스에서 testId, questionNum, questionId 에 따른 값 가져오기   
		List<questionDTO> question = questionService.readQuestionAndAnswer(testId, questionNum, questionId);
		// ajax로 보내기 
		return question;
		}
	
	@RequestMapping(value = "/delete_ok/{id}", method = RequestMethod.GET)
	public String deletePostOK(@PathVariable("id") int id) {
		int i = commentService.deleteComment(id);
		
		if(i == 0) System.out.println("Error! delete Failed");
		else System.out.println("댓글 삭제 완료.");
		
		return "redirect:../result";
	}
	
	@RequestMapping(value = "/addok", method = RequestMethod.POST)
	public String addPostOK(HttpServletRequest request) throws ParseException, UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		//HttpSession session = request.getSession();
		//String userid = request.getSession().getAttribute("").toString();
		commentDTO dto = new commentDTO();

		if(request.getSession().getAttribute("tempUser") != null) {
			int userId = ((userDTO)request.getSession().getAttribute("tempUser")).getId();
			dto.setUserId(userId);

		}
		int testId = 1;
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
    	Date regDate=f.parse(f.format(new Date()));
		
		String comment = request.getParameter("comment");
		
		dto.setComment(comment);
		dto.setRegDate(regDate);
		dto.setTestId(testId);
		
		
		int i = commentService.insertComment(dto);
		if(i==0) {
			System.out.println("데이터 추가 실패 ");
			
		}
		else {
			System.out.println("데이터 추가 성공 ");
		}


		return "redirect:result";
	}
	/*
	// ajax로 값을 주고받는 Controller 
		@RequestMapping(value = "/resu", method = RequestMethod.POST)
		public @ResponseBody String ajax_question(@RequestParam("mbtiType") String mbtiType) {
							
			int testId = 1;
			int questionId = 1;
			// ajax로부터 받은 문제 번호를 1증가 시키고 questionId에도 해당 값 부여   
			//questionNum++;
			//questionId = questionNum;
			System.out.println(mbtiType);
			
			
			// 데이터베이스에서 testId, questionNum, questionId 에 따른 값 가져오기   
			//List<questionDTO> question = questionService.readQuestionAndAnswer(testId, questionNum, questionId);
			// ajax로 보내기 
			return mbtiType;
			}
			*/
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView teamA_result(Model model, HttpServletRequest request , @RequestParam("resultURL") String resultType) {
		ModelAndView mv = new ModelAndView();
		System.out.println("result page loaded");
		
		int testId = 1;
		if(request.getSession().getAttribute("tempUser") != null) {
			int userId = ((userDTO)request.getSession().getAttribute("tempUser")).getId();
			mv.addObject("userId", userId);
		}
		

		List<commentDTO> comment = new ArrayList<commentDTO>();

		comment = commentService.getCommentList(testId);
		
		int count = comment.size();
		
		mv.addObject("comments",comment);
		mv.addObject("count", count);
		mv.setViewName("teamA/result/ENTP");
		System.out.println(resultType);
		System.out.println(mv);

		return mv;
	}
	@RequestMapping(value = "/result/ENTP", method = RequestMethod.GET)
	public ModelAndView teamC_result(Model model, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("result page loaded");
		
		int testId = 1;
		if(request.getSession().getAttribute("tempUser") != null) {
			int userId = ((userDTO)request.getSession().getAttribute("tempUser")).getId();
			mv.addObject("userId", userId);
		}			
		List<commentDTO> comment = new ArrayList<commentDTO>();

		comment = commentService.getCommentList(testId);
		
		int count2 = comment.size();
		System.out.println(count2);
	
		
		mv.addObject("comments",comment);
		mv.addObject("count", count2);
		mv.setViewName("teamA/result/ENTP");
		
		System.out.println(mv);
		
		return mv;
	}
}

