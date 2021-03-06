package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Auto;

@Repository("repositorioAuto")
public interface AutoRepositorio extends JpaRepository<Auto, Serializable>
{
	public abstract List<Auto> findByCodigoAuto(Integer codigo);
	public abstract Auto findOneByCodigoAuto(Integer codigo);
	@Query("select max(a.codigoAuto) from Auto a ")
	public Integer devolverCodigoAutoMaximo();
	
	
}
