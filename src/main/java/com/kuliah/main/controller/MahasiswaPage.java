package com.kuliah.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kuliah.main.entity.Mahasiswa;
import com.kuliah.main.services.ModelMahasiswa;

@Controller
public class MahasiswaPage {
	
	@Autowired
	ModelMahasiswa modelMahasiswa;
	
	
	@GetMapping("/mahasiswa/view")
	public String viewIndexMahasiswa(Model model) {
		
		model.addAttribute("listMahasiswa",modelMahasiswa.getAllMahasiswa());
		model.addAttribute("active",1);
		model.addAttribute("test","Test Aja");
		
		return "view_mahasiswa";
	}
	
	
	@GetMapping("/mahasiswa/add")
	public String viewAddMahasiswa(Model model) {
		
		// buat penampung data mahasiswa di halaman htmlnya
		model.addAttribute("mahasiswa",new Mahasiswa());
		
		return "add_mahasiswa";
	}
	
	@PostMapping("/mahasiswa/view")
	  public String addMahasiswa(@ModelAttribute Mahasiswa mahasiswa, Model model) {
		
		// buat penampung data mahasiswa di halaman htmlnya
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String plainPassword = mahasiswa.getPassword();
		String encodedPassword = passwordEncoder.encode(plainPassword);
        mahasiswa.setPassword(encodedPassword);		
		
		this.modelMahasiswa.addMahasiswa(mahasiswa);
		model.addAttribute("listMahasiswa",modelMahasiswa.getAllMahasiswa());
		
		
		return "redirect:/mahasiswa/view";
	}
	
	
	@GetMapping("/mahasiswa/update/{id}")
	public String viewUpdateMahasiswa(@PathVariable String id, Model model) {
		
		Mahasiswa mahasiswa = modelMahasiswa.getMahasiswaById(id);
		// buat penampung data mahasiswa di halaman htmlnya
		model.addAttribute("mahasiswa",mahasiswa);
		
		return "add_mahasiswa";
	}
	
	@GetMapping("/mahasiswa/delete/{id}")
	public String deleteMahasiswa(@PathVariable String id, Model model) {
		
		this.modelMahasiswa.deleteMahasiswa(id);
		model.addAttribute("listMahasiswa",modelMahasiswa.getAllMahasiswa());
		
		
		return "redirect:/mahasiswa/view";
	}

}
