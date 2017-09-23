package com.mkyong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alex on 04.08.2016.
 */
@Controller
public class userPage {
    @RequestMapping(value = "a/user/add", method = RequestMethod.GET)
    public String addAuthor(){return "addUser";}

    @RequestMapping(value = "a/user/adding", method = RequestMethod.GET)
    public String addAuthor(@RequestParam("login") String login, @RequestParam("pass") String pass,
                            @RequestParam("admin") String b, ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        User user = new User(login, pass, b.equals("TRUE"));
        jdbcControl.insertUser(user);
        return listUser(modelMap);
    }
    @RequestMapping(value = "a/user/list", method = RequestMethod.GET)
    public String listUser(ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        ArrayList<User> list = jdbcControl.allUsers();
        modelMap.addAttribute("list", list);
        return "listUser";
    }

    @RequestMapping(value = "a/user/edit/{login}", method = RequestMethod.GET)
    public String editUser(@PathVariable("login") String login, ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        User user = jdbcControl.getUser(login);
        modelMap.addAttribute("user", user);
        return "editUser";
    }
    @RequestMapping(value = "a/user/editing", method = RequestMethod.GET)
    public String editUser(@RequestParam("login") String login, @RequestParam("password") String password,
                             @RequestParam("admin") boolean admin,  ModelMap modelMap) {
        User user = new User(login, password, admin);
        jdbcControl jdbcControl = new jdbcControl();
        jdbcControl.updateUser(user);
        return listUser(modelMap);
    }
    @RequestMapping(value = "a/user/delete/{login}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("login") String login, ModelMap modelMap) {
        jdbcControl jdbcControl = new jdbcControl();
        jdbcControl.deleteUser(login);
        return listUser(modelMap);
    }
}
