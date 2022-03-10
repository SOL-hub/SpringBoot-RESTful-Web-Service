package com.sole.restfulwebservice.helloworld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	//GET
	// /hello-world(endpoint)
	//어떤 형식인지 알려주는 (method = RequestMethod.GET, path="/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World");
		//기본적인 spring 값이 아니라 자바 빈 형태로 반환하여 스프링프레임워크에서는 제이슨형태로 변환하여 반환해준다.
		//restController를 사용하면 반환하는 것이 배열, 컬렉션으로 반환하면 제이슨 형태로 반환
		
		//레스트컨트롤러를 사용하면 반환하려는 것이 레스판스바디가 아니더라도 반환가능, 
		//단순한 스트링의 값이 아닌 자바빈형태로 반환, 롬복설정
	}
	
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s" + name));
	}
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("", null, locale);
		
	}
	
}
