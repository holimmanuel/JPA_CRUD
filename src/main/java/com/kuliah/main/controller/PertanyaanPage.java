
  
package com.kuliah.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kuliah.main.entity.MataKuliah;
import com.kuliah.main.entity.Pertanyaan;
import com.kuliah.main.services.ModelPertanyaan;
import com.kuliah.main.utility.FileUtility;

@Controller
public class PertanyaanPage {

	@Autowired
	ModelPertanyaan modelPertanyaan;

    private final String UPLOAD_DIR = "./src/main/resources/static/uploads/";

	@GetMapping("/pertanyaan/view")
	public String viewIndexPertanyaan(Model model) {
		model.addAttribute("listpertanyaan",modelPertanyaan.getAllPertanyaan());
		model.addAttribute("active",4);
		return "view_pertanyaan";
	}
	
	@GetMapping("/pertanyaan/add")
	public String viewAddPertanyaan(Model model) {
		model.addAttribute("pertanyaan",new Pertanyaan());
		return "add_pertanyaan";
	}
	
	
	
	@PostMapping("/pertanyaan/vieew")
	public String addPertanyaan(@RequestParam(value = "file")MultipartFile file,@ModelAttribute Pertanyaan pertanyaan, Model model) throws IOException { {
		   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		  
	         
	        String uploadDir = "user-photos/" ;
	
	        FileUtility.saveFile(uploadDir, fileName, file);
	 
          pertanyaan.setStatusGambar("/"+uploadDir + fileName);
           this.modelPertanyaan.addPertanyaan(pertanyaan);

		model.addAttribute("listpertanyaan",modelPertanyaan.getAllPertanyaan());
		
		return "redirect:/pertanyaan/view";
	  }
	}
	
	@GetMapping("/pertanyaan/delete/{id}")
	public String deletePertanyaan(@PathVariable String id, Model model) {
		
		this.modelPertanyaan.deletePertanyaan(id);
		
		
		return "redirect:/pertanyaan/view";
	}
	
	@GetMapping("/pertanyaan/update/{id}")
	public String viewUpdatePertanyaan(@PathVariable String id, Model model) {
		
		Pertanyaan pertanyaan = modelPertanyaan.cariPertanyaan(id);
		// buat penampung data MataKuliah di halaman htmlnya
		model.addAttribute("pertanyaan",pertanyaan);
		
		return "add_pertanyaan";
	}
}