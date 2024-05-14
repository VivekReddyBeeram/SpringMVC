package com.reddy.vivek;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Arrays;

//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
//	@RequestMapping("add")
//	public String add(HttpServletRequest req) {
//		int a= Integer.parseInt(req.getParameter("num1"));
//		int b= Integer.parseInt(req.getParameter("num2"));
//		int c=a+b;
//		
//		HttpSession session=req.getSession();
//		session.setAttribute("res", c);
//		
//		return "result.jsp";
//	}
//	
//	@RequestMapping("add1")
//	public String add(@RequestParam("num3") int i, @RequestParam("num4") int j, HttpSession session) {
//		int c=i+j;
//		session.setAttribute("res",c);
//		
//		return "result.jsp";
//	}

	@RequestMapping("add2")
	public ModelAndView add(@RequestParam("num1") int i, @RequestParam("num2") int j) {
		int c=i+j;
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("res", c);
		return mv;
	}
	
	@RequestMapping("add3")
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m) {//Yu can also use ModelMap instead of Model
		int c=i+j;
		m.addAttribute("res",c);
		
		return "result";
	}
	
	@RequestMapping("addAnimal")
	public String addAnimal(@ModelAttribute("res") Animal an) {
		
		return "result";
	}
	
	@ModelAttribute//This method is called first and sets the values in the model
	public void welcomeMsg(Model m) {
		m.addAttribute("welcomemsg", "Anna Namaste Ne");
	}
	
	@RequestMapping(value="addAnimal1", method=RequestMethod.GET)//specifically mentining method=RequestMethod.POST restricts the method from accepting only post requests
	public String addAnimal1(@ModelAttribute("res") Animal an) {
		return "result";
	}
	
	@RequestMapping(value="addAnimal1", method=RequestMethod.POST)
	public String addAnimal2(@ModelAttribute("res") Animal an) {
		return "result";
	}
	
	@GetMapping("getAnimal")//Simplified version. we can also use PostMapping the same way
	public String getAnimals(Model m) {
		Animal ani=new Animal("Lion",12);
		List <Animal> list= Arrays.asList(ani, new Animal("Tiger", 9), new Animal("cheetah",7));
		m.addAttribute("res",list.toString() );
		return "result";
	}
	
}
