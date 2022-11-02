package com.teamdigital.web.service;

import java.util.List;

import com.teamdigital.web.entity.Mensajeria;

public interface MensajeriaService {

	public List<Mensajeria> mostrarTodasMensaje();
	public List<Mensajeria> mostrarMensajeriaByCanti(String cantidadEntrada);
	
	public Mensajeria guardarMensaje(Mensajeria mensajeria);
	
	public Mensajeria mostrarMnesajeriaId(Long id);
	
	public Mensajeria actualizarMensajeria(Mensajeria mensajeria);
	
	public void eliminarMensajeriaId(Long id);
	
	
}
