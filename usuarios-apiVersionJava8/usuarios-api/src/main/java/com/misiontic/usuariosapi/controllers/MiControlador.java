package com.misiontic.usuariosapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiControlador {
	
	@GetMapping(value="metodo-saludar")
	public String saludar() {
		return "Hola como estas";
	}
}