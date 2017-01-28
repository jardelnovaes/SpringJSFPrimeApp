package com.jardelnovaes.spring.samples.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jardelnovaes.spring.samples.model.User;
import com.jardelnovaes.spring.samples.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	private final static String BASE_PATH = "users/";
	
	@Autowired
	public UserService userService;
	
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {        
    	ModelAndView mv = new ModelAndView(BASE_PATH + "index", "users", userService.getAll());        
        return mv;
    }
     
    @RequestMapping(value = "/api/all", method = RequestMethod.GET)
    public @ResponseBody List<User> getAllRest() {
        return userService.getAll();
    }
	
}
