package com.test.PARKSOL.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	//첫 페이지
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	//회원등록
	@GetMapping(value = "/join")
	public String join() {
			return "join";
		}
		

	//목록조회
	@GetMapping(value = "/list")
	public String list() {
		return "/list";
		}
			
	//글 등록
	@GetMapping(value = "/write")
	public String write() throws Exception{
		return "write";
		}
	

}
