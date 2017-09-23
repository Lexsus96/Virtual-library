package com.mkyong.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Alex on 12.08.2016.
 */
@Controller
public class welcome {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView user(ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelMap.addAttribute("name", auth.getName());
        ModelAndView model = new ModelAndView();
        model.setViewName("welcome");
        return model;

    }

    @RequestMapping(value = "/welcome/personalArea", method = RequestMethod.GET)
    public String personalArea(ModelMap modelMap) {
        return "personalArea";
    }

    @RequestMapping(value = "/welcome/myBook", method = RequestMethod.GET)
    public String myBooks(ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        jdbcControl jdbcControl = new jdbcControl();
        ArrayList<Book> list = jdbcControl.getBooksOfUSer(login);
        modelMap.addAttribute("list", list);
        return "myBook";
    }
    @RequestMapping(value = "/welcome/myBook/back/{isbn}", method = RequestMethod.GET)
    public String backBook(@PathVariable("isbn") String isbn, ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        jdbcControl.backBook(login, isbn);
        return myBooks(modelMap);
    }
    @RequestMapping(value = "/welcome/search", method = RequestMethod.GET)
    public String search(ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        ArrayList<Book> list = jdbcControl.allBook();
        modelMap.addAttribute("list",list);
        return "search";
    }
    @RequestMapping(value = "/welcome/search/read/{isbn}", method = RequestMethod.GET)
    public String readBook(@PathVariable("isbn") String isbn, ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        jdbcControl.readBook(login, isbn);
        return search(modelMap);
    }
    @RequestMapping(value = "/welcome/searching", method = RequestMethod.GET)
    public String readBook(@RequestParam("search_param") String param, @RequestParam("x") String request, ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        ArrayList<Book> list = new ArrayList<Book>();
        if(param.equals("all"))
            list = jdbcControl.allBook();
        else if(param.equals("author"))
            list = jdbcControl.searchAuthor(request);
        else if(param.equals("title"))
            list = jdbcControl.searchTitle(request);
        else if(param.equals("year"))
            list = jdbcControl.searchYear(request);
        modelMap.addAttribute("list", list);
        return "search";
    }
}
