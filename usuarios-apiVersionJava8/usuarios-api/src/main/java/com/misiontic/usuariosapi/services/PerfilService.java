package com.misiontic.usuariosapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.usuariosapi.entity.Perfil;
import com.misiontic.usuariosapi.repository.PerfilRepository;
import com.misiontic.usuariosapi.validators.PerfilValidator;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepo;

	public Perfil findById(Long perfilId) {
		Perfil objPerfil = perfilRepo.findById(perfilId)
				.orElseThrow(() -> new RuntimeException("No existe el perfil."));
		return objPerfil;
	}

	@Transactional
	public void delete(Long perfilId) {
		Perfil objPerfil = perfilRepo.findById(perfilId)
				.orElseThrow(() -> new RuntimeException("No existe el perfil."));

		perfilRepo.delete(objPerfil);
	}

	public List<Perfil> findAll() {
		List<Perfil> perfiles = perfilRepo.findAll();
		return perfiles;
	}

	@Transactional
	public Perfil create(Perfil perfil) {
		PerfilValidator.save(perfil);
		
		Perfil nuevoPerfil = perfilRepo.save(perfil);
		return nuevoPerfil;
	}

	@Transactional
	public Perfil update(Perfil perfil) {
		Perfil existePerfil = perfilRepo.findById(perfil.getId())
				.orElseThrow(() -> new RuntimeException("No existe el perfil."));
		
		existePerfil.setNombre(perfil.getNombre());
		perfilRepo.save(existePerfil);
		return existePerfil;
	}
}
