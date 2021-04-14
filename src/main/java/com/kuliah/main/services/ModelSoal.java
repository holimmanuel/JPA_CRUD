package com.kuliah.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuliah.main.entity.Soal;
import com.kuliah.main.repository.SoalRepository;

@Service
public class ModelSoal  implements ModelSoalInterface{
	
	@Autowired
	SoalRepository SoalRepo;

	@Override
	public List<Soal> getAllSoal() {
		// TODO Auto-generated method stub
		return (List<Soal>) this.SoalRepo.findAll();
	}

	

	@Override
	public Soal addSoal(Soal Soal) {
		// TODO Auto-generated method stub
		
		return  this.SoalRepo.save(Soal);
	
	}

	@Override
	public Soal getSoalById(String id) {
		// TODO Auto-generated method stub
		
		return 	(Soal)this.SoalRepo.findById(Long.parseLong(id)).get();
		
		
	}

	@Override
	public void deleteSoal(String id) {
		// TODO Auto-generated method stub
		this.SoalRepo.deleteById(Long.parseLong(id));
		
	}



	@Override
	public Soal getSoalByName(String name) {
		// TODO Auto-generated method stub
		return this.SoalRepo.findByNamaSoal(name);
	}

}
