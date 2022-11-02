package com.teamdigital.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamdigital.web.entity.Usuario;
import com.teamdigital.web.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	
	
	
	@Autowired
	private IUsuarioRepository repositorio;
	@Override
	public List<Usuario> listarTodosUsu() {
		
		return repositorio.findAll();
	}
	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return repositorio.save(usuario);
	}
	@Override
	public Usuario buscarIdUsu(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public Usuario update(Usuario usuario) {
		return repositorio.save(usuario);
	}
	@Override
	public void delete(Long id) {
		repositorio.deleteById(id);
	}
	
	
	
	//FK//
	@Override
	public List<Usuario> listarUsuFk() {
		return repositorio.findAllSortByName();
	}
	@Override
	public List<Usuario> listarDocumentoUsu(String documento) {
		return repositorio.findByTitleContaining(documento);
	}
	

}
