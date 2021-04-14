package com.kuliah.main.services;

import java.util.List;

import com.kuliah.main.entity.Soal;

public interface ModelSoalInterface {
	
	public List<Soal> getAllSoal();
	public Soal getSoalByName(String name);
	
	public Soal addSoal(Soal Soal);
	public Soal getSoalById(String id);
	public void deleteSoal(String id);

}
