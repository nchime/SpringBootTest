package com.mnlsolution.chime.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mnlsolution.chime.domain.Account;
import com.mnlsolution.chime.repository.AccountRepository;
import com.mnlsolution.chime.service.UserDetailsImpl;

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
	public void adminPage(Authentication authentication) {
		
		UserDetailsImpl user =  (UserDetailsImpl) authentication.getPrincipal();
		logger.info("***************** adminPage {}", user.getRegitime());
		logger.info("***************** adminPage {}", user.getNick());
		logger.info("***************** adminPage {}", user.getPassword());
		logger.info("***************** adminPage {}", user.getDept());
	}

	@RequestMapping("/user")
	public void userPage() {
		logger.info("***************** userPage ");
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
		 logger.info("***************** login ");
		 logger.info("Getting login page, error={}", error);
		 return new ModelAndView("login", "error", error);		
	}
	
	
	
	
	@RequestMapping("/test2/{test}")
	public String test2(@PathVariable("test") String test) {
		
		logger.info(test);
		
		return "redirect:/";
		
	}
	
	
	
	
	
	@RequestMapping("/logout")
	public void logout() {
		logger.info("***************** logout ");		
	}
	
	@RequestMapping(value = "/registform", method=RequestMethod.GET)
	public String registform(Locale locale, Model model) {
		
		logger.info("***************** registform ");		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", "현재 시간은 :" + formattedDate);
		
		return "registform"; 
	}
	
	
	@Autowired
	AccountRepository AccountRepository; 
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public  String register(Account account) {
		logger.info("***************** register ");
		
		logger.info(" Account : " + account.toString());
		
		
		// 비밀번호 암호화 처리
		account.setPassword(passwordEncoder.encode(account.getPassword())); 
		
		
		// 회원정보 DB 저장 
		AccountRepository.save(account);
		
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(account);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetailsImpl, null, userDetailsImpl.getAuthorities()); 
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return "redirect:/";
		
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
	
	@RequestMapping(value = "/test", method=RequestMethod.GET)
	public String test(@RequestParam String param1, @RequestParam String param2) {
		
		logger.info(param1);
		logger.info(param2);		
		
		return "redirect:/";
		
	}

}
