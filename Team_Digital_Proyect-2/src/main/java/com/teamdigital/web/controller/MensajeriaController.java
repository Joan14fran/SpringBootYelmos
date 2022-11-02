package com.teamdigital.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.teamdigital.web.entity.Mensajeria;
import com.teamdigital.web.entity.Reserva;
import com.teamdigital.web.repository.IReservaRepository;
import com.teamdigital.web.service.MensajeriaServiceImpl;

@Controller
public class MensajeriaController {
	
	@Autowired
	private MensajeriaServiceImpl mensajeriaService;
	@Autowired
	private IReservaRepository reservaRepository;
	
	private List<Reserva> reservaList = new ArrayList<>();
	
	public MensajeriaController(MensajeriaServiceImpl mensajeriaService, IReservaRepository reservaRepository) {
		this.mensajeriaService = mensajeriaService;
		this.reservaRepository = reservaRepository;
		
		this.reservaList = this.reservaRepository.findAllSortByName();
	}
	
	@GetMapping("/mensajeria")
	public String listarMensajerias(Model modelo) {
		modelo.addAttribute("mensajerias",mensajeriaService.mostrarTodasMensaje());
		return "mensajeria";
	}
	
	@GetMapping("/mensajeria/crear")
	public String crearMensajeriaForm(Model modelo) {
		Mensajeria mensajeria = new Mensajeria();
		
		modelo.addAttribute("mensajerias",mensajeria);
		modelo.addAttribute("reservaList",reservaList);
		
		return "crear_mensajeria";
	}
	
	@PostMapping("/mensajeria")
	public String guardarMensajeria(@ModelAttribute("mensajeria")Mensajeria mensajeria) {
		mensajeriaService.guardarMensaje(mensajeria);
		return "redirect:/mensajeria";
	}
	@GetMapping("/mensajeria/editar/{id}")
	public String mostrarFormEdit(@PathVariable Long id,Model modelo) {
		modelo.addAttribute("mensajerias",mensajeriaService.mostrarMnesajeriaId(id));
		modelo.addAttribute("reservaList",reservaList);
		
		return "editar_mensajeria";
	}
	
	@PostMapping("/mensajeria/{id}")
	public String update(@PathVariable Long id,
			@ModelAttribute("mensajerias")Mensajeria mensajeria,
			Model modelo) {
		
		Mensajeria mensajeriaExistente = mensajeriaService.mostrarMnesajeriaId(id);
		
		mensajeriaExistente.setCantidadEntrada(mensajeria.getCantidadEntrada());
		mensajeriaExistente.setObservaciones(mensajeria.getObservaciones());
		mensajeriaExistente.setReserva_fk(mensajeria.getReserva_fk());
		
		mensajeriaService.actualizarMensajeria(mensajeriaExistente);
		
		return "redirect:/mensajeria";
	}
	
	@GetMapping("/mensajeria/{id}")
	public String eliminarMensajeria(@PathVariable Long id) {
		mensajeriaService.eliminarMensajeriaId(id);
		return "redirect:/mensajeria";
	}

}
