package alkemy.challenge.Challenge.Alkemy.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import alkemy.challenge.Challenge.Alkemy.entity.Usuario;

public class MyUserDetails implements UserDetails{
	
	private String name;
	private String password;
	
	private List<GrantedAuthority> authorities;
	
	public MyUserDetails(Usuario usuario) {
		this.name = usuario.getUsername();
		this.password = usuario.getPassword();
		
		this.authorities = Arrays.stream(usuario.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return name;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}

}
