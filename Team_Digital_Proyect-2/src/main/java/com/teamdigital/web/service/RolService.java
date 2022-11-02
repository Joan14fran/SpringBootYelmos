package com.teamdigital.web.service;

import java.util.List;

import com.teamdigital.web.entity.Rol;

public interface RolService {

	public List<Rol> listarRol();
	
	public List<Rol> listarRolNombre(String nombreRol);
	
	public Rol guardarRol(Rol rol);
	
	public Rol buscarIdRol(Long id);
	
	public Rol update(Rol rol);
	
	public void deleteIdRol(Long id);
	
	
	
	
	
}
