package com.mkyong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.*;
/**
 * Created by Alex on 03.08.2016.
 */
@Controller
public class bookPage {

    @RequestMapping(value = "a/book/delete", method = RequestMethod.GET)
    public String deleteBook() {
        return "deleteBook";
    }

    @RequestMapping(value = "a/book/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") String id, ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        Book book = jdbcControl.getBook(id);
        jdbcControl.deleteBook(book);
        return listBook(modelMap);
    }

    @RequestMapping(value = "a/book/add", method = RequestMethod.GET)
    public String addBook(ModelMap modelMap) throws SQLException {
        jdbcControl jdbcControl = new jdbcControl();
        ArrayList<Author> list = jdbcControl.allAuthors();
        modelMap.addAttribute("list", list);
        return "addBook";
    }

    @RequestMapping(value = "a/book/adding", method = RequestMethod.GET)
    public String addBook(@RequestParam("title") String title, @RequestParam("year") String year,
                          @RequestParam("isbn") String isbn, @RequestParam("author") String author_id, ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        Author author = null;
            author = jdbcControl.getAuthor(author_id);
        Book book = new Book(title, year, author, isbn);
        jdbcControl.insertBook(book);
        return listBook(modelMap);
    }

    @RequestMapping(value = "a/book/edit/{id}", method = RequestMethod.GET)
    public String editThisBook(@PathVariable("id") String id, ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        ArrayList<Author> list = jdbcControl.allAuthors();
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("book", jdbcControl.getBook(id));
        return "editBook";
    }

    @RequestMapping(value = "a/book/editing", method = RequestMethod.GET)
    public String editBook(@RequestParam("title") String title, @RequestParam("year") String year,
                           @RequestParam("author") String author_id, @RequestParam("isbn") String isbn, ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        Author author = jdbcControl.getAuthor(author_id);
        Book book = new Book(title, year, author, isbn);
        jdbcControl.updateBook(book);
        return listBook(modelMap);
    }
    @RequestMapping(value = "a/book/list", method = RequestMethod.GET)
    public String listBook(ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        ArrayList<Book> list = jdbcControl.allBook();
        modelMap.addAttribute("list", list);
        return "listBook";
    }
}
