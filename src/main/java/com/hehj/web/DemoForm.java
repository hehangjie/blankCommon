package com.hehj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hehj.common.vo.PageResult;
import com.hehj.entity.Demo;
import com.hehj.service.DemoService;

@Controller
public class DemoForm {

	// @Autowired
	// private DemoDao demoDao;
	//
	// @RequestMapping(value = "/demo")
	// public ModelAndView demoForm() {
	// List<Demo> list = demoDao.loadAll();
	// ModelAndView view = new ModelAndView();
	// view.setViewName("demo");
	// view.addObject("list", list);
	// return view;
	// }

	@Autowired
	private DemoService demoService;
	private Demo search;

	@RequestMapping(value = "/demo/{currentPage}")
	public ModelAndView demoListRequest(@PathVariable int currentPage) {
		PageResult<Demo> result = demoService.pageResault(search, currentPage);
		ModelAndView view = new ModelAndView();
		view.setViewName("demo");
		view.addObject("result", result);
		return view;
	}

	@RequestMapping(value = "/demo", method = RequestMethod.POST)
	public ModelAndView demoListSearch(@ModelAttribute Demo search) {
		this.search = search;
		PageResult<Demo> result = demoService.pageResault(search, 1);
		ModelAndView view = new ModelAndView();
		view.setViewName("demo");
		view.addObject("result", result);
		return view;
	}
}
