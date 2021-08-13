package alkemy.challenge.Challenge.Alkemy.service;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import alkemy.challenge.Challenge.Alkemy.entity.Genero;
import alkemy.challenge.Challenge.Alkemy.entity.PeliculaoSerie;

public interface PeliculaoSerieService {
	
	public Iterable<PeliculaoSerie> findAll();
	
	public Page<PeliculaoSerie> findAll(Pageable pageable);
	
	public Optional<PeliculaoSerie> findById(Long id);
	
	public PeliculaoSerie save(PeliculaoSerie peliculaoSerie);
	
	public void deleteById(Long id);
	
	
}
