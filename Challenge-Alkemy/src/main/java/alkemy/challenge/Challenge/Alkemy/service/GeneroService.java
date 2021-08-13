package alkemy.challenge.Challenge.Alkemy.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import alkemy.challenge.Challenge.Alkemy.entity.Genero;

public interface GeneroService {
	
	public Iterable<Genero> findAll();
	
	public Page<Genero> findAll(Pageable pageable);
	
	public Optional<Genero> findById(Long id);
	
	public Genero save(Genero genero);
	
	public void deleteById(Long id);

}
