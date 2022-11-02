package com.teamdigital.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.teamdigital.web.entity.Usuario;
import com.teamdigital.web.repository.IUsuarioRepository;

@SpringBootApplication
public class TeamDigitalProyect2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TeamDigitalProyect2Application.class, args);
	}

	@Autowired
	private
	IUsuarioRepository respositorio;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		Usuario usaurio1 = new Usuario("Johan","Peña","francojha32@gmail.com","121030","Activo","12345","1");
		respositorio.save(usaurio1);
		Usuario usaurio2 = new Usuario("Andres","Peña","andreas4522@gmail.com","45213","Inactivo","45231","2");
		respositorio.save(usaurio2);*/
		
		
		
		
	}

}
