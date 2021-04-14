package com.kuliah.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.kuliah.main.repository.MahasiswaRepository;
import com.kuliah.main.services.ModelMahasiswa;

@Controller
public class HomePage {
	
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		

		return "index";
		
	}
	
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		

		return "login";
		
	}
	
	

}
