package alkemy.challenge.Challenge.Alkemy.repository;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import alkemy.challenge.Challenge.Alkemy.entity.Genero;
import alkemy.challenge.Challenge.Alkemy.entity.PeliculaoSerie;

@Repository
public interface PeliculaoSerieRepository extends JpaRepository<PeliculaoSerie, Long>{
	
	Optional<PeliculaoSerie> findByTitulo(String titulo);
	
	//List<PeliculaoSerie> findByGenero(Genero genero);
}
