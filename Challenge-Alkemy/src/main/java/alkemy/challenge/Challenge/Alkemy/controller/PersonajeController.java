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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alkemy.challenge.Challenge.Alkemy.entity.Personaje;
import alkemy.challenge.Challenge.Alkemy.service.PersonajeService;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeController {
	
	@Autowired
	private PersonajeService personajeService;
	
	@Autowired

	

	
	// crear un nuevo personaje
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Personaje personaje) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personajeService.save(personaje));
	}
	
	// Leer un personaje
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long personajeId) {
		Optional<Personaje> oPersonaje = personajeService.findById(personajeId);
		
		if(!oPersonaje.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oPersonaje);
	}
	
	//Actualizar un personaje
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Personaje personajeDetails, @PathVariable(value = "id") Long personajeId) {
		Optional<Personaje> personaje = personajeService.findById(personajeId);
		
		if(!personaje.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		personaje.get().setNombre(personajeDetails.getNombre());
		personaje.get().setImagen(personajeDetails.getImagen());
		personaje.get().setEdad(personajeDetails.getEdad());
		personaje.get().setPeso(personajeDetails.getPeso());
		personaje.get().setHistoria(personajeDetails.getHistoria());
		personaje.get().setPeliculasAsociadas(personajeDetails.getPeliculasAsociadas());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personajeService.save(personaje.get()));
	}
	
	// borrar un personaje
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long personajeId) {
		
		if(!personajeService.findById(personajeId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		personajeService.deleteById(personajeId);
		return ResponseEntity.ok().build();
	}
	
	// leer todos los personajes
	@GetMapping
	public List<Personaje> readAll () {
		
		List<Personaje> personaje = StreamSupport
				.stream(personajeService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return personaje;
		
		
	}
	
	
	

}
