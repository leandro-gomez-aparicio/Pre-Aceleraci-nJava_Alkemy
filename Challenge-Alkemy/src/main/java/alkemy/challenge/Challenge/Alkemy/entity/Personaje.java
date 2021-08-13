package alkemy.challenge.Challenge.Alkemy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Personaje implements Serializable{
	
	
	private static final long serialVersionUID = 5185809810090031379L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String imagen;
	
	@Column(length = 50)
	private String nombre;
	
	private Integer edad;
	
	private Float peso;
	
	private String historia;
	
	private String peliculasAsociadas;

	

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}
	
	public String getPeliculasAsociadas() {
		return peliculasAsociadas;
	}

	public void setPeliculasAsociadas(String peliculasAsociadas) {
		this.peliculasAsociadas = peliculasAsociadas;
	}
	
}
