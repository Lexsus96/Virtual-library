package com.mkyong.web.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.*;

@Controller
public class StartPage {

	@RequestMapping(value = "/signPage", method = RequestMethod.GET)
	public static String signIn() {
		jdbcControl jdbcControl = new jdbcControl();
		jdbcControl.deleteLog();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "redirect:/welcome";
		}
		return "signPage";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public static String index() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return "redirect:/signPage";
		}
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/a", method = RequestMethod.GET)
	public static String printWelcome(ModelMap modelMap) {
		jdbcControl jdbcControl = new jdbcControl();
		ArrayList<Log> list = jdbcControl.logs();
		modelMap.addAttribute("list", list);
		return "hello";
	}
	@RequestMapping(value = "a/clear", method = RequestMethod.GET)
	public String logClear(ModelMap modelMap) {
		jdbcControl jdbcControl = new jdbcControl();
		jdbcControl.deleteLog();
		return printWelcome(modelMap);
	}
	@RequestMapping(value = "a/authentication", method = RequestMethod.GET)
	public static String printWelcome(@RequestParam("Login") String login, @RequestParam("Pass") String pass, ModelMap modelMap) {
		jdbcControl jdbcControl = new jdbcControl();
		if(jdbcControl.signIn(login,pass)) {
			ModelAndView model = new ModelAndView();
			model.setViewName("hello");
			model.addObject("msg", login);
			ArrayList<Log> list = jdbcControl.logs();
			modelMap.addAttribute("list", list);
			return "hello";
		}
		return "signPage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		model.setViewName("403");
		return model;

	}

}