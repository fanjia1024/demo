package com.imooc.demo.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BackIndexController {
 
	@RequestMapping(value = "/back",method = RequestMethod.GET)
	public String index() {
		
		return "backindex.html";
	}
	
}
