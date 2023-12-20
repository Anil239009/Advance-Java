package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor of "+getClass());
	}
	//req handling method
	@RequestMapping("/")
	public String showIndexPage() {
		System.out.println("in show index page");
		return "/index";//LVN --> D.S --> V.R --> AVN : /WEB-INF/views/index.jsp
	}

}
