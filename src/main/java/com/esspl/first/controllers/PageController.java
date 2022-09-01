package com.esspl.first.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.esspl.first.model.Category;
import com.esspl.first.modelattribute.User;
import com.esspl.first.modelattribute.UserRepository;
import com.esspl.first.services.CategoryService;
import com.esspl.first.services.ProductService;

@Controller
public class PageController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value={"/","/index"})
	public ModelAndView index(ModelMap model) {
		ModelAndView mv=new ModelAndView("masterpage");
		model.put("UserClickIndex", true);
		model.put("title","Index");
		return mv;
	}
	
	
	
	@RequestMapping("/home")
	public ModelAndView home(ModelMap model) {
		ModelAndView mv=new ModelAndView("masterpage");
		model.put("product",productService.getProduct());
		model.put("category",categoryService.retriveAll());
		model.put("title","Home");
		model.put("UserClickHome", true);
		return mv;
	}
	
	
	@RequestMapping("/product")
	public ModelAndView product(ModelMap model) {
		ModelAndView mv=new ModelAndView("masterpage");
		model.put("UserClickProduct", true);
		model.put("product",productService.getProduct());
		model.put("category",categoryService.retriveAll());
		model.put("title","Product");
		return mv;
	}
	
	@RequestMapping("/category")
	public ModelAndView category(ModelMap model) {
		ModelAndView mv=new ModelAndView("masterpage");
		model.put("UserClickCategory", true);
		model.put("category",categoryService.retriveAll());
		model.put("title","Category");
		return mv;
	}
	@PreAuthorize("hasRole('USER')")
	@RequestMapping("/about")
	public ModelAndView about(ModelMap model) {
		ModelAndView mv=new ModelAndView("masterpage");
		model.put("UserClickAbout", true);
		model.put("title","About");
		return mv;
	}
	
	/*
	 * @RequestMapping("/register") public ModelAndView testing(ModelMap model) {
	 * ModelAndView mv=new ModelAndView("masterpage");
	 * model.put("UserClickRegister", true); model.put("title","New_User"); return
	 * mv; }
	 */
	

	
	@RequestMapping("/register")
	public ModelAndView register(@ModelAttribute User user) {
		ModelAndView mv=new ModelAndView("masterpage");
		mv.addObject("UserClickNew",true);
		try {
			
			userRepository.save(user);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mv;
	}
	
	
	
	@RequestMapping("/form")
	public String form(ModelMap model,Category category) {
		model.put("test", "this is first testing of my jsp");
		return "redirect:masterpage";
	}
	
	
	
	
}
