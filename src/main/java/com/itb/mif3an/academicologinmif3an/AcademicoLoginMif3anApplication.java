package com.itb.mif3an.academicologinmif3an;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.itb.mif3an.academicologinmif3an.model.Papel;
import com.itb.mif3an.academicologinmif3an.repository.PapelRepository;
import com.itb.mif3an.academicologinmif3an.service.UsuarioService;

@SpringBootApplication
public class AcademicoLoginMif3anApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicoLoginMif3anApplication.class, args);
	}

	
	@Bean
	CommandLineRunner run(UsuarioService usuarioService, PapelRepository papelRepository) {
		
		return args -> {
			if(papelRepository.findAll().size() == 0) {
			usuarioService.saveRole(new Papel("ROLE_USER"));
			usuarioService.saveRole(new Papel("ROLE_ADMIN"));
			usuarioService.saveRole(new Papel("ROLE_INSTRUCTOR"));
			usuarioService.saveRole(new Papel("ROLE_STUDENT"));
			}
		};
	}
	
}
