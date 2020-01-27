package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Variante;

@Repository("repositorioVariante")
public interface VarianteRepositorio extends JpaRepository<Variante, Serializable>{
	public Variante findById(Integer id);
	
}
