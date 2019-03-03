package com.synex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

@RequestMapping("/")
public ModelAndView display(){
	ModelAndView model= new ModelAndView("home");
	model.addObject("message","Hello Everyone");
	return model;
	
}

@RequestMapping("/Admin")
public ModelAndView displayAdmin(){
	ModelAndView model= new ModelAndView("Admin");
  return model;
}


@RequestMapping("/SearchUser")
public ModelAndView dispalyAdmin(){
	ModelAndView model= new ModelAndView("SearchUser");
	
	return model;
}



@RequestMapping("/userDetails")
public ModelAndView userDetails(@RequestParam("loginName") String loginName) {
	ModelAndView model = new ModelAndView("userDetails");
	model.addObject("loginName", loginName);
	return model;
}

}