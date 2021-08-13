package alkemy.challenge.Challenge.Alkemy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alkemy.challenge.Challenge.Alkemy.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByName(String name);
	
	Optional<Usuario> findByEmail(String email);
	
	
	

}
