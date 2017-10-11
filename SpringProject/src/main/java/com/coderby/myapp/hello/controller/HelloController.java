package com.coderby.myapp.hello.controller;

import com.coderby.myapp.hello.service.HelloService;
import com.coderby.myapp.hello.service.IHelloService;

public class HelloController {
	IHelloService helloService = new HelloService();
	
	public void hello(String name) {
		System.out.println("HelloController" + helloService.sayHello(name));
	}
}
