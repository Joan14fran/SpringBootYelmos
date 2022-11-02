package com.teamdigital.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teamdigital.web.entity.Reserva;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Long>{
	
	@Query("FROM Reserva r WHERE r.id like :title")
	List<Reserva> findByTitleContaining(@Param("title")String title);
	
	@Query("FROM Reserva r ORDER BY id ASC")
	public List<Reserva> findAllSortByName();

}
