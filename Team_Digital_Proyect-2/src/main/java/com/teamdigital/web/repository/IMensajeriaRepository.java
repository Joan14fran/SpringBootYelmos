package com.teamdigital.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teamdigital.web.entity.Mensajeria;
@Repository
public interface IMensajeriaRepository extends JpaRepository<Mensajeria,Long> {

	@Query("FROM Mensajeria m WHERE m.cantidadEntrada LIKE :cantidadEntrada OR m.observaciones LIKE :antidadEntrada")
	public List<Mensajeria> findByNameContaining(@Param("cantidadEntrada")String antidadEntrada);
	
}
