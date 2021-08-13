package alkemy.challenge.Challenge.Alkemy.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import alkemy.challenge.Challenge.Alkemy.entity.Usuario;
import alkemy.challenge.Challenge.Alkemy.service.UsuarioService;


@RestController

public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	
	
	
	// crear un nuevo usuario
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Usuario usuario) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}
	
	// Leer un usuario
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long usuarioId) {
		Optional<Usuario> oUsuario = usuarioService.findById(usuarioId);
		
		if(!oUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oUsuario);
	}
	
	//Actualizar un usuario
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Usuario usuarioDetails, @PathVariable(value = "id") Long usuarioId) {
		Optional<Usuario> usuario = usuarioService.findById(usuarioId);
		
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		usuario.get().setUsername(usuarioDetails.getUsername());
		usuario.get().setSurname(usuarioDetails.getSurname());
		usuario.get().setEmail(usuarioDetails.getEmail());
		usuario.get().setPassword(usuarioDetails.getPassword());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));
	}
	
	// borrar un usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long usuarioId) {
		
		if(!usuarioService.findById(usuarioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		usuarioService.deleteById(usuarioId);
		return ResponseEntity.ok().build();
	}
	
	// leer todos los usuarios
	@GetMapping
	public List<Usuario> readAll () {
		
		List<Usuario> usuario = StreamSupport
				.stream(usuarioService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return usuario;
		
		
		
		
	}

}
