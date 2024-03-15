package com.itb.mif3an.academicologinmif3an.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.itb.mif3an.academicologinmif3an.model.Papel;
import com.itb.mif3an.academicologinmif3an.model.Usuario;

@Service
public interface UsuarioService extends UserDetailsService {
	
	Usuario findByEmail(String email);
	Usuario save(Usuario usuario);
	void addRoleToUser(String username, String roleName);
	Papel saveRole(Papel papel);
}
