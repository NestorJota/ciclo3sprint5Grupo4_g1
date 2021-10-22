package com.misiontic.usuariosapi.validators;

import com.misiontic.usuariosapi.entity.Perfil;

public class PerfilValidator {
	
	public static void save(Perfil perfil) {
		
		if (perfil.getNombre() == null || perfil.getNombre().trim().isEmpty()) {
			throw new RuntimeException("El nombre es requerido");
		}
		
		if (perfil.getNombre().length() > 100) {
			throw new RuntimeException("El nombre del perfil es muy largo max 100 caracteres.");
		}
		
	}

}
