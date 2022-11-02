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

import com.teamdigital.web.entity.Rol;
import com.teamdigital.web.entity.Usuario;
import com.teamdigital.web.repository.IRolRepository;
import com.teamdigital.web.service.UsuarioService;
import com.teamdigital.web.service.UsuarioServiceImpl;

@Controller
@RequestMapping
public class UsuarioController {
	
	//Roles
	@Autowired
	private IRolRepository rolRepository;
	private List<Rol> rolList = new ArrayList<>();
	
	@Autowired
	private UsuarioService service;
	
	public UsuarioController(UsuarioServiceImpl service, IRolRepository rolRepository) {
		this.service = service;
		this.rolRepository = rolRepository;
		
		this.rolList = this.rolRepository.findAllSortByName();
	}
	
	@GetMapping("/usuarios")
	public String listarUsuarios(Model modelo) {
		modelo.addAttribute("usuarios",service.listarTodosUsu());
		return "usuarios";//archivo.html
	}
	@GetMapping("/usuarios/crear")
	public String crearUsuarioFormRegis(Model modelo) {
		
		Usuario usuario = new Usuario();
		
		modelo.addAttribute("usuario",usuario);
		modelo.addAttribute("rolList",rolList);
		
		return "crear_usu";
	}
	
	@PostMapping("/usuarios")
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		service.guardarUsuario(usuario);
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios/editar/{id}")
	public String mostrarFormEdit(@PathVariable Long id,Model modelo) {
		
		modelo.addAttribute("usuario",service.buscarIdUsu(id));
		modelo.addAttribute("rolList",rolList);
		
		return "editar_usuario";
	}
	
	@PostMapping("/usuarios/{id}")
	public String update(@PathVariable Long id, 
			@ModelAttribute("usuario") Usuario usuario
			,Model modelo) {
		//Mostrar datos por id
		Usuario usuarioExsitente = service.buscarIdUsu(id);
		//editarlo
		usuarioExsitente.setId(id);
		usuarioExsitente.setNombre(usuario.getNombre());
		usuarioExsitente.setApellido(usuario.getApellido());
		usuarioExsitente.setEmail(usuario.getEmail());
		usuarioExsitente.setDocumento(usuario.getDocumento());
		usuarioExsitente.setEstado(usuario.getEstado());
		usuarioExsitente.setContrasena(usuario.getContrasena());
		usuarioExsitente.setRol_fk(usuario.getRol_fk());
		
		//Guardar datos
		service.update(usuarioExsitente);
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios/{id}")
	public String eliminarUsuario(@PathVariable Long id) {
		service.delete(id);
		return"redirect:/usuarios";
		
	}

}
