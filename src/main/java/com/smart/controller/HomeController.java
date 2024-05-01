package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.smart.dao.UserRepository;
import com.smart.entities.User;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("title","home-smart contact maneger");
		return"home";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		
		model.addAttribute("title","about-smart contact maneger");
		return"about";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		
		model.addAttribute("title","Register-smart contact maneger");
		model.addAttribute("user",new User());
		
		return"signup";
	}
	
	//handler for registering user
    @PostMapping("/do_register")
	public String registerUser(@ModelAttribute User user)

	{
		System.out.println(user);
		User u=userRepository.save(user);
		if(u!=null) {
			System.out.println("Register succesfully");
		}else {
			System.out.println("Error");
		}
		
		return"signup";
	}
    
    // handler for login 
    @RequestMapping("/signin")
	public String cutomlogin(Model model) {
		
		model.addAttribute("title","login-smart contact maneger");
		return "login";
	}
}
