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

import alkemy.challenge.Challenge.Alkemy.entity.Genero;
import alkemy.challenge.Challenge.Alkemy.service.GeneroService;

@RestController
@RequestMapping("/api/genero")
public class GeneroController {
	
	@Autowired
	private GeneroService generoService;
	
	// Crear un nuevo genero
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Genero genero) {
		return ResponseEntity.status(HttpStatus.CREATED).body(generoService.save(genero));
	}
	
	// Leer un genero
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long generoId) {
		Optional<Genero> oGenero = generoService.findById(generoId);
		
		if(!oGenero.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oGenero);
	}
	
	//Actualizar genero
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Genero generoDetails, @PathVariable(value = "id") Long generoId) {
		Optional<Genero> genero = generoService.findById(generoId);
		
		if(!genero.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		genero.get().setImagen(generoDetails.getImagen());
		genero.get().setNombre(generoDetails.getNombre());
		//genero.get().setPeliculaoSerie(generoDetails.getPeliculaoSerie());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(generoService.save(genero.get()));
		
	}
	
	// borrar un genero
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long generoId) {
		if(!generoService.findById(generoId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		generoService.deleteById(generoId);
		return ResponseEntity.ok().build();
	}
	
	// Leer todos los generos
	@GetMapping
	public List<Genero> readAll () {
		List<Genero> genero = StreamSupport
				.stream(generoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return genero;
		
	}

}
