package com.teamdigital.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teamdigital.web.entity.Mensajeria;
import com.teamdigital.web.repository.IMensajeriaRepository;

@Service
public class MensajeriaServiceImpl implements MensajeriaService{

	private IMensajeriaRepository mensajeriaRepository;
	
	public MensajeriaServiceImpl(IMensajeriaRepository mensajeriaRepository) {
		this.mensajeriaRepository = mensajeriaRepository;
	}
	
	
	@Override
	public List<Mensajeria> mostrarTodasMensaje() {
		// TODO Auto-generated method stub
		return mensajeriaRepository.findAll();
	}

	@Override
	public List<Mensajeria> mostrarMensajeriaByCanti(String cantidadEntrada) {
		// TODO Auto-generated method stub
		return mensajeriaRepository.findByNameContaining(cantidadEntrada);
	}

	@Override
	public Mensajeria guardarMensaje(Mensajeria mensajeria) {
		// TODO Auto-generated method stub
		return mensajeriaRepository.save(mensajeria);
	}

	@Override
	public Mensajeria mostrarMnesajeriaId(Long id) {
		// TODO Auto-generated method stub
		return mensajeriaRepository.findById(id).get();
	}

	@Override
	public Mensajeria actualizarMensajeria(Mensajeria mensajeria) {
		// TODO Auto-generated method stub
		return mensajeriaRepository.save(mensajeria);
	}

	@Override
	public void eliminarMensajeriaId(Long id) {
		// TODO Auto-generated method stub
		mensajeriaRepository.deleteById(id);
		
	}

}
