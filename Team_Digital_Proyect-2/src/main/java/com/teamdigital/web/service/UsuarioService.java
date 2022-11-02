package com.teamdigital.web.service;

import java.util.List;

import com.teamdigital.web.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> listarTodosUsu();
	
	public List<Usuario> listarUsuFk();
	
	public List<Usuario> listarDocumentoUsu(String nombre);
	
	 public Usuario guardarUsuario(Usuario usuario);
	 
	 public Usuario buscarIdUsu(Long id);
	 
	 public Usuario update(Usuario usuario);
	 
	 public void delete(Long id);
	 
	 
}
