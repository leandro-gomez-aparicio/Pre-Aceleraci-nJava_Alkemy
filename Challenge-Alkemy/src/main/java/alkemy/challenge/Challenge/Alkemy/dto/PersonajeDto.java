package alkemy.challenge.Challenge.Alkemy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor


public class PersonajeDto {
	
	private Long id;
	private String nombre;
	private Integer edad;
	private Integer peso;
	private String historia;
	private String imagen;
	private String peliculasAsociadas;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getPeliculasAsociadas() {
		return peliculasAsociadas;
	}
	public void setPeliculasAsociadas(String peliculasAsociadas) {
		this.peliculasAsociadas = peliculasAsociadas;
	}

	
}
