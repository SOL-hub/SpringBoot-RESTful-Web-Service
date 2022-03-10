package com.test.PARKSOL.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Test용 컨트롤러
@RestController
public class TestController {
	
	@GetMapping(path = "/Test")
	public String Test() {
		return "Testok";
	}
	
	@GetMapping(path="/Test-bean")
	public TestBean TestBean() {
		return new TestBean("TestOk2");
	}
	
	@GetMapping(path="/Test-bean/path-variable/{name}")
	public TestBean TestBean(@PathVariable String name) {
		return new TestBean(String.format("home, %s" + name));
	}

}
