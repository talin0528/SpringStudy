package com.coderby.myapp.hello.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {

	@Override
	public String sayHello(String name) {
		System.out.println("HelloService.sayHello() 실행");
		String message = "Hello, " + name;
		return message;
	}

	@Override
	public String sayGoodbye(String name) {
		System.out.println("HelloService.sayGoodbye() 실행");
		String message = "Goodbye, " + name;
		if(Math.random() < 0.5) {
			throw new RuntimeException("Goodbye Exception");
		}
		
		return message;
	}

}
