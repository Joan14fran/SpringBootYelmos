package com.teamdigital.web.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "rol",length = 50)
	private String nombreRol;
	
	 
	 
	 public Rol() {
			
		}


	public Rol(String nombreRol) {
		super();
		this.nombreRol = nombreRol;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, nombreRol);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombreRol, other.nombreRol);
	}

	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombreRol() {
		return nombreRol;
	}


	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}




	@Override
	public String toString() {
		return "Rol [nombreRol=" + nombreRol + "]";
	}
	
	
	 
	 
	 
	
}
