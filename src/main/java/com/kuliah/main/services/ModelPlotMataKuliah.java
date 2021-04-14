package com.kuliah.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuliah.main.entity.PlotMataKuliah;
import com.kuliah.main.repository.PlotMataKuliahRepository;

@Service
public class ModelPlotMataKuliah  implements ModelPlotMataKuliahInterface{
	
	@Autowired
	PlotMataKuliahRepository PlotMataKuliahRepo;

	@Override
	public List<PlotMataKuliah> getAllPlotMataKuliah() {
		// TODO Auto-generated method stub
		return (List<PlotMataKuliah>) this.PlotMataKuliahRepo.findAll();
	}

	

	@Override
	public PlotMataKuliah addPlotMataKuliah(PlotMataKuliah PlotMataKuliah) {
		// TODO Auto-generated method stub
		
		return  this.PlotMataKuliahRepo.save(PlotMataKuliah);
	
	}

	@Override
	public PlotMataKuliah getPlotMataKuliahById(String id) {
		// TODO Auto-generated method stub
		
		return 	(PlotMataKuliah)this.PlotMataKuliahRepo.findById(Long.parseLong(id)).get();
		
		
	}

	@Override
	public void deletePlotMataKuliah(String id) {
		// TODO Auto-generated method stub
		this.PlotMataKuliahRepo.deleteById(Long.parseLong(id));
		
	}



	

}
