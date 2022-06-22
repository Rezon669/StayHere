package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class createaccountcontroller {

	@Autowired
	createaccountrepo repo1;
	
	/*
	@RequestMapping("/")
	public String details()
	{
			return "createaccount";
		}*/
	
	@RequestMapping("/")
	public String loginpage()
	{
			return "login";
		}
	
	@RequestMapping("/createaccount")
	public String createacc(createaccount c)
	{
		repo1.save(c);
			return "createaccount";
		}
	
	@RequestMapping("/login")
	public String login()
	{
			return "login";
		}
	
	@RequestMapping("/homepage")
	public String homepage()
	{
		return "homepage";
		}
	
	
	
	@RequestMapping("/create")
	public String createaccount(createaccount c)
	{
		//repo1.save(c);
	//	System.out.println(100);
		return "create";
		
		}
	
	@RequestMapping("/forgotpassword")
	public String forgotpassword()
	{
		//System.out.println(100);
		return "Forgotpassword";
		
		}
	
	@RequestMapping("/buyproperty")
	public String buyproperty()
	{
		return "buyproperty";
		
		}
	@RequestMapping("/sellproperty")
	public String sellproperty()
	{
		return "sellproperty";
		
		}
	@RequestMapping("/hireproperty")
	public String hireproperty()
	{
		return "hireproperty";
		
		}
	@RequestMapping("/rentproperty")
	public String rentproperty()
	{
		return "rentproperty";
		
		}
	
/*
	@RequestMapping("/{cid}")
	@ResponseBody
	public String getcustomersbyid(@PathVariable("cid") int cid) {
		return repo1.findById(cid).toString();

	}*/

}

/*
@GetMapping("/getdetails")	
public ModelAndView getdetails(@RequestParam int cid)
{
	ModelAndView mv= new ModelAndView("retrive");
	createaccount customers=repo1.findById(cid).orElse(null);
	mv.addObject(customers);
	return mv;
}
}
/*
@RequestMapping("/customers")
@ResponseBody
public String getcustomers() {
	return repo.findAll().toString();

}
*/
