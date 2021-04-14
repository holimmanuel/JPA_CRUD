package com.kuliah.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuliah.main.entity.Dosen;
import com.kuliah.main.repository.DosenRepository;

@Service
public class ModelDosen  implements ModelDosenInterface{
	
	@Autowired
	DosenRepository DosenRepo;

	@Override
	public List<Dosen> getAllDosen() {
		// TODO Auto-generated method stub
		return (List<Dosen>) this.DosenRepo.findAll();
	}

	

	@Override
	public Dosen addDosen(Dosen Dosen) {
		// TODO Auto-generated method stub
		
		return  this.DosenRepo.save(Dosen);
	
	}

	@Override
	public Dosen getDosenById(String id) {
		// TODO Auto-generated method stub
		
		return 	((Dosen)this.DosenRepo.findByIdDosen(Long.parseLong(id)));
		
		
	}

	@Override
	public void deleteDosen(String id) {
		// TODO Auto-generated method stub
		this.DosenRepo.deleteById(Long.parseLong(id));
		
	}



	@Override
	public Dosen getDosenByName(String name) {
		// TODO Auto-generated method stub
		return this.DosenRepo.findByNamaDosen(name);
	}

}
