package alkemy.challenge.Challenge.Alkemy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import alkemy.challenge.Challenge.Alkemy.entity.PeliculaoSerie;
import alkemy.challenge.Challenge.Alkemy.entity.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
	
	Optional<Personaje> findByNombre(String nombre);
	
}
