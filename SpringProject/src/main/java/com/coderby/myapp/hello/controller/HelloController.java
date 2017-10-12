package com.coderby.myapp.hello.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.coderby.myapp.hello.service.IHelloService;

@Controller
public class HelloController {
	
	@Resource(name="helloServiceProxy")
	IHelloService helloService;
	
	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;
	}
	
	public void hello(String name) {
		System.out.println("HelloController" + helloService.sayHello(name));
	}
}
