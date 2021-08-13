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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import alkemy.challenge.Challenge.Alkemy.dto.PeliculaoSerieDto;
//import alkemy.challenge.Challenge.Alkemy.entity.Genero;
import alkemy.challenge.Challenge.Alkemy.entity.PeliculaoSerie;
import alkemy.challenge.Challenge.Alkemy.service.PeliculaoSerieService;

@RestController
@RequestMapping("/api/peluculaoSerie")
public class PeliculaoSerieController {
	
	@Autowired
	private PeliculaoSerieService peliculaoSerieService;
	
	// crear una nueva pelicula o serie
	@PostMapping
	public ResponseEntity<?> create (@RequestBody PeliculaoSerie peliculaoSerie) {
		return ResponseEntity.status(HttpStatus.CREATED).body(peliculaoSerieService.save(peliculaoSerie));
		
	}
	
	// Leer una serie o pelicula
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long peliculaoSerieId) {
		Optional<PeliculaoSerie> oPeliculaoSerie = peliculaoSerieService.findById(peliculaoSerieId);
		
		if(!oPeliculaoSerie.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oPeliculaoSerie);
	}
	
	// Actualizar pelicula o serie
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody PeliculaoSerie peliculaoSerieDetails, @PathVariable(value = "id") Long peliculaoSerieId) {
		Optional<PeliculaoSerie> peliculaoSerie = peliculaoSerieService.findById(peliculaoSerieId);
		
		if(!peliculaoSerie.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		peliculaoSerie.get().setTitulo(peliculaoSerieDetails.getTitulo());
		peliculaoSerie.get().setImagen(peliculaoSerieDetails.getImagen());
		peliculaoSerie.get().setFechaDeCreacion(peliculaoSerieDetails.getFechaDeCreacion());
		peliculaoSerie.get().setCalificacion(peliculaoSerieDetails.getCalificacion());
		//peliculaoSerie.get().setPersonaje(peliculaoSerieDetails.getPersonaje());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(peliculaoSerieService.save(peliculaoSerie.get()));
		
		
	}
	
	// Borrar una pelicula o serie
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long peliculaoSerieId) {
		if(!peliculaoSerieService.findById(peliculaoSerieId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		peliculaoSerieService.deleteById(peliculaoSerieId);
		return ResponseEntity.ok().build();
	}
	
	// Leer pelicula o serie
	@GetMapping
	public List<PeliculaoSerie> readAll () {
		List<PeliculaoSerie> peliculaoSerie = StreamSupport
				.stream(peliculaoSerieService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return peliculaoSerie;
	}
	
	
	//@GetMapping(params = "genero")
	//public List<PeliculaoSerieDto> getPeliculasPorGenero(@RequestParam(value = "genero") Long id){
	//	return createPeliculasListDto(peliculaoSerieService
	//			.buscarPeliculasPorGenero(new Genero(id)));
	//}
	
	//private List<PeliculaoSerieDto> createPeliculasListDto(List<PeliculaoSerie> pelicula){
	//	List<PeliculaoSerieDto> response = pelicula.stream()
	//			.map(pelicula -> createPeliculaDto(pelicula))
	//			.collect(Collectors.toList());
	//	return response;
	//}
	
	//private PeliculaoSerieDto createPeliculaDto(PeliculaoSerie pelicula) {
	//	return new PeliculaoSerieDto(
	//			pelicula.getId(),
	//			pelicula.getTitulo(),
	//			pelicula.getFechaDeCreacion(),
	//			pelicula.getCalificacion(),
	//			pelicula.getImagen(),
	//			pelicula.getGenero().getNombre()
	//			);
	//}

}
