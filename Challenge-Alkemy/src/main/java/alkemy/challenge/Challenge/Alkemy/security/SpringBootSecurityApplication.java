package alkemy.challenge.Challenge.Alkemy.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import alkemy.challenge.Challenge.Alkemy.repository.UsuarioRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UsuarioRepository.class)
public class SpringBootSecurityApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

}
