package com.teamdigital.web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teamdigital.web.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("FROM Usuario u WHERE u.nombre LIKE :title")
	List<Usuario> findByTitleContaining(@Param("title")String title);
	
	@Query("FROM Usuario u ORDER BY nombre ASC")
	public List<Usuario> findAllSortByName();
	

}
