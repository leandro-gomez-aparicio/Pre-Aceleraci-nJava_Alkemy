package alkemy.challenge.Challenge.Alkemy.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import alkemy.challenge.Challenge.Alkemy.entity.Usuario;
import alkemy.challenge.Challenge.Alkemy.repository.UsuarioRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = usuarioRepository.findByName(name);
		
		usuario.orElseThrow(() -> new UsernameNotFoundException("Not found: " + name));
		
		return usuario.map(MyUserDetails::new).get();
		
	}

}
