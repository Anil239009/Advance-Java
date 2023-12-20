package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mandatory cls level annotation to tell SC ,
//following is a req handling controller(=Handler) spring bean
//whose life cycle will be managed by SC
//singleton , eager
public class HelloWorldController {
	public HelloWorldController() {
		System.out.println("in ctor of " + getClass());
	}
	//add method level annotation to tell SC about
	//request mapping info
	@RequestMapping("/hello")
	//In HandlerMapping bean : entry is created
	//Key : /hello 
	//Value : com.app.controller.HelloWorldController.sayHello
	public String sayHello() {
		System.out.println("in say hello");
		return "/welcome";//=> Logical view Name(LVN)
		//Handler's method --> rets LVN --> D.S --> V.R --> rets
		//AVN : /WEB-INF/views/welcome.jsp
	}

}
