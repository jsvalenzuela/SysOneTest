package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Opcion;
@Repository("repositorio")
public interface OpcionRepositorio extends JpaRepository<Opcion, Serializable> {
	public Opcion findById(Integer id);
	@Query("select o.codigoOpcion from Opcion o where o.id = ?1 ")
    public String getCodigoOpcion(Integer id);
}
