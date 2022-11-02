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
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamdigital.web.entity.Reserva;
import com.teamdigital.web.entity.Usuario;
import com.teamdigital.web.repository.IUsuarioRepository;
import com.teamdigital.web.service.ReservaService;
import com.teamdigital.web.service.ReservaServiceImpl;

@Controller
@RequestMapping
public class ReservaController {
	
	//Usuarios
	@Autowired
	private IUsuarioRepository usuarioReposiotry;
	private List<Usuario> usuList = new ArrayList<>();
	
	@Autowired
	private ReservaService service;
	
	public ReservaController(ReservaServiceImpl service, IUsuarioRepository usuarioReposiotry) {
		this.service = service;
		this.usuarioReposiotry = usuarioReposiotry;
		
		this.usuList = this.usuarioReposiotry.findAllSortByName();
	}
	@GetMapping("/reservas")
	public String listarReservas(Model modelo) {
		modelo.addAttribute("reservas",service.listarTodasReservas());
		return "reservas";//archivo htmll
	}
	@GetMapping("/reservas/crear")
	public String crearReservaForm(Model modelo) {
		Reserva reserva = new Reserva();
		
		modelo.addAttribute("reserva",reserva);
		modelo.addAttribute("usuList",usuList);
		
		return "crear_reserva";//archivo htmll
	}
	@PostMapping("/reservas")
	public String guardarReserva(@ModelAttribute("reserva")Reserva reserva) {
		service.guardarReserva(reserva);
		return "redirect:/reservas";
	}
	@GetMapping("/reservas/editar/{id}")
	public String mostrarReseId(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("reserva",service.buscarIdRes(id));
		modelo.addAttribute("usuList",usuList);
		
		return "editar_reserva";
	}
	@PostMapping("/reservas/{id}")
	public String update(@PathVariable Long id, 
			@ModelAttribute("reserva") Reserva reserva) {
		//Mostrar datos por id//
		Reserva reservaExistente = service.buscarIdRes(id);
		//editarlo
		reservaExistente.setId(id);
		reservaExistente.setDireccion(reserva.getDireccion());
		reservaExistente.setEmail(reserva.getEmail());
		reservaExistente.setTelefono(reserva.getTelefono());
		reservaExistente.setLocalidad(reserva.getLocalidad());
		reservaExistente.setFechaInicio(reserva.getFechaInicio());
		reservaExistente.setFechaFin(reserva.getFechaFin());
		reservaExistente.setUsuario_fk(reserva.getUsuario_fk());
		
		service.update(reservaExistente);
		
		return "redirect:/reservas";
	}
	@GetMapping("/reservas/{id}")
	public String eliminarReserva(@PathVariable Long id) {
		service.delete(id);
		return"redirect:/reservas";
	}

}
