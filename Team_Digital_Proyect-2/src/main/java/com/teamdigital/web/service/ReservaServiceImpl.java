package com.teamdigital.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamdigital.web.entity.Reserva;
import com.teamdigital.web.repository.IReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private IReservaRepository repositorio;
	@Override
	public List<Reserva> listarTodasReservas() {
		return repositorio.findAll();
	}

	@Override
	public Reserva guardarReserva(Reserva reserva) {
		return repositorio.save(reserva);
	}

	@Override
	public Reserva buscarIdRes(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Reserva update(Reserva reserva) {
		return repositorio.save(reserva);
	}

	@Override
	public void delete(Long id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Reserva> getReservaById(String id) {
		// TODO Auto-generated method stub
		return repositorio.findByTitleContaining(id);
	}

	@Override
	public List<Reserva> listarTodasReservasFk() {
		// TODO Auto-generated method stub
		return repositorio.findAllSortByName();
	}
	

}
