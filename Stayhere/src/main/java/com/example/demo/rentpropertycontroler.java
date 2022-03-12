package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class rentpropertycontroler {
@Autowired
	rentpropertyrepo rrepo;
		
@PostMapping("/rentpro")
public String rentpropertyy(rentproperty rent) {
	System.out.println(100);
			rrepo.save(rent);
			//System.out.println(200);
			return "thankyou";
		}
		
		
	/*	@GetMapping("/buyproperty")
		public String buyproperty() {
			String list = ("SELECT * FROM sellproperty");
			System.out.println(100);
		//	return "srepo.findall()";
			return "buyproperty";
		}*/
		
		@GetMapping("/hireproperty")	
		public ModelAndView hirepropertydata()
		{
			ModelAndView mv= new ModelAndView("hireproperty");
			List<rentproperty> r=rrepo.findAll();
			mv.addObject("rlist",r);
			mv.setViewName("hireproperty");
			return mv;
		}
}
