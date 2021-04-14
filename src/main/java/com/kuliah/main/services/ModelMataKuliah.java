package com.kuliah.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuliah.main.entity.MataKuliah;
import com.kuliah.main.repository.MataKuliahRepository;

@Service
public class ModelMataKuliah  implements ModelMataKuliahInterface{
	
	@Autowired
	MataKuliahRepository MataKuliahRepo;

	@Override
	public List<MataKuliah> getAllMataKuliah() {
		// TODO Auto-generated method stub
		return (List<MataKuliah>) this.MataKuliahRepo.findAll();
	}

	

	@Override
	public MataKuliah addMataKuliah(MataKuliah MataKuliah) {
		// TODO Auto-generated method stub
		
		return  this.MataKuliahRepo.save(MataKuliah);
	
	}

	@Override
	public MataKuliah getMataKuliahById(String id) {
		// TODO Auto-generated method stub
		
		return 	((MataKuliah)this.MataKuliahRepo.findByIdMataKuliah(Long.parseLong(id)));
		
		
	}

	@Override
	public void deleteMataKuliah(String id) {
		// TODO Auto-generated method stub
		this.MataKuliahRepo.deleteById(Long.parseLong(id));
		
	}



	@Override
	public MataKuliah getMataKuliahByName(String name) {
		// TODO Auto-generated method stub
		return this.MataKuliahRepo.findByNamaMataKuliah(name);
	}

}
