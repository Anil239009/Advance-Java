package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test") // => all the URLs with /test : url-pattern
//will be handled by this TestController
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass());
	}
	//req handling method
	@GetMapping("/test1")//=> @RequestMapping(method=GET)
	//key : /test/test1
	//value : TestController.testModelAndView
	public ModelAndView testModelAndView() {
		System.out.println("in test m&v");
		//o.s.w.s.ModelAndView(String LVN, String modelAttrName,
	//	Object modelAttrValue)
		return new ModelAndView("/test/display"
				, "server_ts", LocalDateTime.now());
	}
}
