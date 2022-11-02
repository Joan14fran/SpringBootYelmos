package com.teamdigital.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teamdigital.web.entity.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {

	@Query("FROM Rol r WHERE r.nombreRol like :title")
	List<Rol> findByTitleContaining(@Param("title")String title);
	
	@Query("FROM Rol r ORDER BY nombreRol ASC")
	public List<Rol> findAllSortByName();
	
	
	
}
