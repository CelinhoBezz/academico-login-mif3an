package com.itb.mif3an.academicologinmif3an.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itb.mif3an.academicologinmif3an.model.Papel;
import com.itb.mif3an.academicologinmif3an.model.Usuario;
import com.itb.mif3an.academicologinmif3an.repository.PapelRepository;
import com.itb.mif3an.academicologinmif3an.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder; 
	
	
	@Override
	public Usuario findByEmail(String email) {
		
		return usuarioRepository.findByEmail(email);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		Usuario usuario = usuarioRepository.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Nome de usuário ou Senha Inválidos");
		}
		
		return new org.springframework.security.core.userdetails.User(usuario.getEmail(),
																	  usuario.getPassword(), mapRolesToAuthorities(usuario.getPapeis()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Papel> papeis){
		
		return papeis.stream().map(papel -> new SimpleGrantedAuthority(papel.getNomePapel())).collect(Collectors.toList());
	}

	@Override
	public Usuario save(Usuario usuario) {
		
		Usuario user = new Usuario( usuario.getNome(),
										usuario.getSobrenome(),
										usuario.getEmail(),
										passwordEncoder.encode(usuario.getPassword()),
										new ArrayList<>());
		
		user.setTipoPrincipalUsuario("ROLE_USER");
		user.setCodStatusUsuario(true);
		usuarioRepository.save(user);
		this.addRoleToUser(user.getEmail(), "ROLE_USER");
		return user;
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		Usuario usuario = usuarioRepository.findByEmail(username);
		Papel papel = papelRepository.findByName(roleName);
		usuario.getPapeis().add(papel);
		usuarioRepository.save(usuario);
		
	}

	@Override
	public Papel saveRole(Papel papel) {
		
		return papelRepository.save(papel);
	}
}
