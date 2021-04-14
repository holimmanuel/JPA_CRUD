package com.kuliah.main.services;

import java.util.List;
import java.util.Optional;

import com.kuliah.main.entity.Pertanyaan;

public interface ModelPertanyaanInterface {
	
	public List<Pertanyaan> getAllPertanyaan();
	
	
	public Pertanyaan addPertanyaan(Pertanyaan mahasiswa);
	
	public void deletePertanyaan(String id);
	
	public Pertanyaan cariPertanyaan(String id);

}
