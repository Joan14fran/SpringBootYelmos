package com.teamdigital.web.service;

import java.util.List;

import com.teamdigital.web.entity.Reserva;

public interface ReservaService {
	
	public List<Reserva> listarTodasReservas();
	
	public List<Reserva> listarTodasReservasFk();
	
	public List<Reserva> getReservaById(String id);
	
	public Reserva guardarReserva(Reserva reserva);
	
	public Reserva buscarIdRes(Long id);
	
	public Reserva update(Reserva reserva);
	
	public void delete(Long id);


}
