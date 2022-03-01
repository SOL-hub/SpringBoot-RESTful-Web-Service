import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sole.restfulwebservice.HelloWorldBean;

@RestController
public class HelloWorldController {
	
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
		
	}
}
