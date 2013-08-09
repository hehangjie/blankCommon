package com.hehj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorld {
	
	@RequestMapping(value="/helloworld")
	public ModelAndView hello() {
		ModelAndView view = new ModelAndView();
		view.setViewName("hello_world");
		return view;
	}
}
