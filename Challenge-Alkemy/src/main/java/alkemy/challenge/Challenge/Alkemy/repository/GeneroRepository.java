package alkemy.challenge.Challenge.Alkemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alkemy.challenge.Challenge.Alkemy.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long>{

}
