package com.mnlsolution.chime.controller;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/")
	public @ResponseBody String homePage() {
		logger.info("***************** homePage ");
		return "Home입니다.<a href=\"/login\"> 로그인 </a>" ;
	}

	@RequestMapping("/test")
	public @ResponseBody String testPage() {
		logger.info("***************** testPage ");
		return "test입니다.<a href=\"/login\"> 로그인 </a>" ;
	}

	@RequestMapping("/admin")
	public void adminPage() {
		logger.info("***************** adminPage ");
	}

	@RequestMapping("/user")
	public void userPage() {
		logger.info("***************** userPage ");
	}
	
	
	@RequestMapping("/login")
	public void login() {
		logger.info("***************** login ");		
	}
	
	@RequestMapping("/logout")
	public void logout() {
		logger.info("***************** logout ");		
	}
	
	@RequestMapping("/403")
	public void accessDeniedPage() {
		logger.info("***************** 403페이지 ");		
	}
	
	
/*	
    @RequestMapping("/user_list.html")
    public ModelAndView getListUsersView() {
        ModelMap model = new ModelMap();
        model.addAttribute("users", userService.getList());
        return new ModelAndView("user_list", model);
    }*/
	

}
