package com.kuliah.main.services;

import java.util.List;

import com.kuliah.main.entity.MataKuliah;

public interface ModelMataKuliahInterface {
	
	public List<MataKuliah> getAllMataKuliah();
	public MataKuliah getMataKuliahByName(String name);
	
	public MataKuliah addMataKuliah(MataKuliah MataKuliah);
	public MataKuliah getMataKuliahById(String id);
	public void deleteMataKuliah(String id);

}
