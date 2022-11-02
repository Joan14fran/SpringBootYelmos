package com.teamdigital.web.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mensajeria")
public class Mensajeria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cantidadEntrada")
	private int cantidadEntrada;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	//Relacion.Reserva
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reserva_fk")
    private Reserva reserva_fk;
	
	
	//Constructor
	public Mensajeria() {
		
	}


	public Mensajeria(int cantidadEntrada, String observaciones) {
		super();
		this.cantidadEntrada = cantidadEntrada;
		this.observaciones = observaciones;
	}

	
	//Get//Set//



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public int getCantidadEntrada() {
		return cantidadEntrada;
	}



	public void setCantidadEntrada(int cantidadEntrada) {
		this.cantidadEntrada = cantidadEntrada;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Reserva getReserva_fk() {
		return reserva_fk;
	}


	public void setReserva_fk(Reserva reserva_fk) {
		this.reserva_fk = reserva_fk;
	}


	
	//To//
	@Override
	public String toString() {
		return "Mensajeria [cantidadEntrada=" + cantidadEntrada + ", observaciones=" + observaciones + "]";
	}
	
	
	
	
	

}
