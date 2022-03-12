package com.example.demo;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class sellpropertycontoller {
	@Autowired
	sellpropertyrepo srepo;
	
	@PostMapping("/sellpro")

	public String sellpropertyy(sellproperty sell) {
		
		srepo.save(sell);
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
	
	@GetMapping("/buyproperty")	
	public ModelAndView buypropertydata()
	{
		ModelAndView mv= new ModelAndView("buyproperty");
		List<sellproperty> s=srepo.findAll();
		mv.addObject("slist",s);
		mv.setViewName("buyproperty");
		return mv;
	}
	@RequestMapping("/filter")

	public String filter() {
		
		return "thankyou";
	}
	 /* @GetMapping("/filtersearch")
	    public String viewHomePage(Model model, @Param("propertytype"), @Param("city"), @Param("country")) String propertytype,String city,String country) {
	        List<sellproperty> list = srepo.search(propertytype, city, country);
	        model.addAttribute("list", list);
	        model.addAttribute("propertytype","city","country", propertytype, city, country);
	         
	        return "buyproperty";
	    }
	*/

}
