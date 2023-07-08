package coms.Springbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class testcontroller {
	@RequestMapping(value="/P1",method=RequestMethod.GET)
	public String page1()
	{
		return "Page1";
	}
	
	@RequestMapping(value="/P2",method=RequestMethod.GET)
	public String page2()
	{
		return "Page2";
	}
	

}
