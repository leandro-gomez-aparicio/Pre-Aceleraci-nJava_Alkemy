package alkemy.challenge.Challenge.Alkemy.entity;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genero")
public class Genero implements Serializable{
	
	
	private static final long serialVersionUID = 6304205796223780190L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String nombre;
	
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
