package com.jardelnovaes.spring.samples.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private final String MESSAGE = "Wellcome to Spring MVC JSF Primefaces Example";
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getHomeView() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("model", MESSAGE);
        return mv;
    }
     
    @RequestMapping(value = "/api/home", method = RequestMethod.GET)
    public @ResponseBody String getHomeRest() {
        return MESSAGE;
    }
	
}
