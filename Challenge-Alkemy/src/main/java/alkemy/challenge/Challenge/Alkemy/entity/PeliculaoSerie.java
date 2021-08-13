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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class PeliculaoSerie implements Serializable{
	
	
	private static final long serialVersionUID = -3208758113863698462L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String imagen;
	
	private String titulo;
	
	private Integer fechaDeCreacion;
	
	private Integer calificacion;
	
	private String personajesAsociados;
	


	

	public PeliculaoSerie(Long id) {
		super();
		this.id = id;
	}
	
	
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(Integer fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		if (calificacion > 5) {
			this.calificacion = 5;
		}
		else if (calificacion < 1) {
			this.calificacion = 1;
		}
		else {
			this.calificacion = calificacion;
		}
		
		
	}
	
	public String getPersonajesAsociados() {
		return personajesAsociados;
	}


	public void setPersonajesAsociados(String personajesAsociados) {
		this.personajesAsociados = personajesAsociados;
	}



}
