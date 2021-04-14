package com.kuliah.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kuliah.main.entity.MataKuliah;
import com.kuliah.main.services.ModelMataKuliah;

@Controller
public class MataKuliahPage {
	
	@Autowired
	ModelMataKuliah modelMataKuliah;
	
	
	@GetMapping("/matakuliah/view")
	public String viewIndexMataKuliah(Model model) {
		
		model.addAttribute("listMataKuliah",modelMataKuliah.getAllMataKuliah());
		model.addAttribute("active",3);
		return "view_matakuliah";
	}
	
	
	@GetMapping("/matakuliah/add")
	public String viewAddMataKuliah(Model model) {
		
		// buat penampung data MataKuliah di halaman htmlnya
		model.addAttribute("matakuliah",new MataKuliah());
		
		return "add_matakuliah";
	}
	
	@PostMapping("/matakuliah/view")
	  public String addMataKuliah(@ModelAttribute MataKuliah MataKuliah, Model model) {
		
		// buat penampung data MataKuliah di halaman htmlnya
		this.modelMataKuliah.addMataKuliah(MataKuliah);
		model.addAttribute("listMataKuliah",modelMataKuliah.getAllMataKuliah());
		
		
		return "redirect:/matakuliah/view";
	}
	
	
	@GetMapping("/matakuliah/update/{id}")
	public String viewUpdateMataKuliah(@PathVariable String id, Model model) {
		
		MataKuliah MataKuliah = modelMataKuliah.getMataKuliahById(id);
		// buat penampung data MataKuliah di halaman htmlnya
		model.addAttribute("matakuliah",MataKuliah);
		
		return "add_matakuliah";
	}
	
	@GetMapping("/matakuliah/delete/{id}")
	public String deleteMataKuliah(@PathVariable String id, Model model) {
		
		this.modelMataKuliah.deleteMataKuliah(id);
		model.addAttribute("listMataKuliah",modelMataKuliah.getAllMataKuliah());
		
		
		return "redirect:/matakuliah/view";
	}

}
