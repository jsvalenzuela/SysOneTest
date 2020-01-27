package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Auto;
import com.example.demo.entities.Opcion;
@Repository("repositorioAuto")
public interface AutoRepositorio extends JpaRepository<Auto, Serializable> {
	

}
