package com.farmarcia.FarmaciaGen.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmarcia.FarmaciaGen.model.UserLogin;
import com.farmarcia.FarmaciaGen.model.Usuario;
import com.farmarcia.FarmaciaGen.repository.UsuarioRepository;
import com.farmarcia.FarmaciaGen.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins="*",allowedHeaders = "*")

	public class UsuarioController {
	
	@Autowired
		private UsuarioService usuarioService;
	@Autowired
		private UsuarioRepository repository;
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Authentication(@RequestBody Optional<UserLogin> user){
		return usuarioService.login(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
		return usuarioService.cadastrarUsuario(usuario)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> Put(@RequestBody Usuario nome) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(nome));
	}
	
}
