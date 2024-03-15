package com.itb.mif3an.academicologinmif3an.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itb.mif3an.academicologinmif3an.model.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long> {
	
	@Query(value="SELECT * FROM papeis p WHERE p.nome_papel=?", nativeQuery=true)
	Papel findByName(String nomePapel);

}
