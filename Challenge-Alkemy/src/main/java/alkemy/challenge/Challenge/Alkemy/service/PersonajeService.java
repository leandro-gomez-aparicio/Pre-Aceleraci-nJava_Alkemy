package alkemy.challenge.Challenge.Alkemy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import alkemy.challenge.Challenge.Alkemy.entity.PeliculaoSerie;
import alkemy.challenge.Challenge.Alkemy.entity.Personaje;

public interface PersonajeService {
	
	public List<Personaje> listar();
	
	public Iterable<Personaje> findAll();
	
	public Page<Personaje> findAll(Pageable pageable);
	
	public Optional<Personaje> findById(Long id);
	
	public Personaje save(Personaje personaje);
	
	public void deleteById(Long id);

}
