package it.uniroma3;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.uniroma3.model.Utente;
import it.uniroma3.service.UserService;


@SpringBootApplication
public class ProgSiw1Application {

	@Autowired UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ProgSiw1Application.class, args);
	}

	@PostConstruct
	public void init() {
		Utente utente = new Utente("simone","simone","RESPONSABILE");
		userService.save(utente);
	}

}
