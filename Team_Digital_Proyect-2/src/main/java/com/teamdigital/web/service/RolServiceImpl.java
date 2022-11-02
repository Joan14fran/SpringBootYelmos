package com.teamdigital.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teamdigital.web.entity.Rol;
import com.teamdigital.web.repository.IRolRepository;

@Service
public class RolServiceImpl implements RolService {
	
	private IRolRepository rolRepository;

	public RolServiceImpl(IRolRepository rolRepository) {
		this.rolRepository = rolRepository;
	}
	
	
	@Override
	public List<Rol> listarRol() {
		return rolRepository.findAllSortByName();
	}

	@Override
	public List<Rol> listarRolNombre(String nombreRol) {
		return rolRepository.findByTitleContaining(nombreRol);
	}

	@Override
	public Rol guardarRol(Rol rol) {
		return rolRepository.save(rol);
	}

	@Override
	public Rol buscarIdRol(Long id) {
		return rolRepository.getById(id);
	}

	@Override
	public Rol update(Rol rol) {
		return rolRepository.save(rol);
	}

	@Override
	public void deleteIdRol(Long id) {
		rolRepository.deleteById(id);
	}

	
	
}
