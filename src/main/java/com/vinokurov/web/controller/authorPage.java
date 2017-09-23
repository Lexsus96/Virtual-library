package com.mkyong.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alex on 03.08.2016.
 */
@Controller
public class authorPage {

    @RequestMapping(value = "a/author/add", method = RequestMethod.GET)
    public String addAuthor(){return "addAuthor";}

    @RequestMapping(value = "a/author/adding", method = RequestMethod.GET)
    public String addAuthor(@RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName,
                            @RequestParam("id") String id,  ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        Author author = new Author(id, firstName, secondName);
        jdbcControl.insertAuthor(author);
        return listAuthor(modelMap);
    }

    @RequestMapping(value = "a/author/list", method = RequestMethod.GET)
    public String listAuthor(ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        ArrayList<Author> list = jdbcControl.allAuthors();
        modelMap.addAttribute("list", list);
        return "listAuthor";
    }

    @RequestMapping(value = "a/author/edit/{id}", method = RequestMethod.GET)
    public String editAuthor(@PathVariable("id") String id, ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        Author author = jdbcControl.getAuthor(id);
        modelMap.addAttribute("author", author);
        return "editAuthor";
    }
    @RequestMapping(value = "a/author/editing", method = RequestMethod.GET)
    public String editAuthor(@RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName,
                             @RequestParam("id") String id,  ModelMap modelMap) {
        Author author = new Author(id, firstName, secondName);
        jdbcControl jdbcControl = new jdbcControl();
        jdbcControl.updateAuthor(author);
        return listAuthor(modelMap);
    }
    @RequestMapping(value = "a/author/delete/{id}", method = RequestMethod.GET)
    public String deleteAuthor(@PathVariable("id") String id, ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        jdbcControl.deleteAuthor(id);
        return listAuthor(modelMap);
    }
}
