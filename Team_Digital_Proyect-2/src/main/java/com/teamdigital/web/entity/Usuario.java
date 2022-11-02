package com.teamdigital.web.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre",length = 50, nullable = false)
	private String nombre;
	
	@Column(name = "apellido",length = 50, nullable = false)
	private String apellido;
	
	@Column(name = "email",length = 50, unique = true, nullable = false)
	private String email;
	
	@Column(name = "documento",length = 50, nullable = false, unique = true)
	private String documento;
	
	@Column(name = "estado",length = 50, nullable = false)
	private String estado;
	
	@Column(name = "contrasena",length = 50, nullable = false)
	private String contrasena;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rol_fk")
    private Rol rol_fk;
	
	
	
	//Cons//
	public Usuario() {
		
	}

	public Usuario(Long id, String nombre, String apellido, String email, String documento, String estado,
			String contrasena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.documento = documento;
		this.estado = estado;
		this.contrasena = contrasena;
	}
	

	//Get//Set//
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	

	public Rol getRol_fk() {
		return rol_fk;
	}

	public void setRol_fk(Rol rol_fk) {
		this.rol_fk = rol_fk;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", documento=" + documento
				+ ", estado=" + estado + ", contrasena=" + contrasena + "]";
	}


	


	
	
	
	
	
	

	
	
	

}
