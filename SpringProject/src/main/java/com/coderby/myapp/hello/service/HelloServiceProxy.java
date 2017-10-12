package com.coderby.myapp.hello.service;

import org.springframework.stereotype.Service;

import com.coderby.myapp.util.HelloLog;

@Service
public class HelloServiceProxy extends HelloService {
	@Override
	public String sayHello(String name) {
		HelloLog.log();
		return super.sayHello(name);
	}

	@Override
	public String sayGoodbye(String name) {
		String message = "Goodbye, " + name;
		return message;
	}

}
