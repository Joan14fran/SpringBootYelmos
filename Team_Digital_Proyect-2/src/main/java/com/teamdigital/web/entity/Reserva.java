package com.teamdigital.web.entity;

import java.util.Date;

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
@Table(name = "reservas")
public class Reserva{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "email", length = 50, unique = true)
	private String email;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "localidad")
	private String localidad;
	@Column(name = "fechaIn")
	private String fechaInicio;
	@Column(name = "fechaFin")
	private String fechaFin;
	
	//Relacion.Usuarios//
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario_fk")
	private Usuario usuario_fk;
	
	public Reserva(){
		
	}

	

	public Reserva(String direccion, String email, String telefono, String localidad, String fechaInicio,
			String fechaFin) {
		super();
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.localidad = localidad;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public String getFechaFin() {
		return fechaFin;
	}



	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}



	public Usuario getUsuario_fk() {
		return usuario_fk;
	}

	public void setUsuario_fk(Usuario usuario_fk) {
		this.usuario_fk = usuario_fk;
	}



	@Override
	public String toString() {
		return "Reserva [direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + ", localidad="
				+ localidad + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}

	
	
	
	
	
	
	

}
