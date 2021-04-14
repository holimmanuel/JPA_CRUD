package com.kuliah.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.kuliah.main.entity.Dosen;
import com.kuliah.main.entity.MataKuliah;

public interface MataKuliahRepository extends CrudRepository<MataKuliah, Long> {
	
	public MataKuliah findByNamaMataKuliah(String nama);
	public MataKuliah findByIdMataKuliah(Long id);

}
