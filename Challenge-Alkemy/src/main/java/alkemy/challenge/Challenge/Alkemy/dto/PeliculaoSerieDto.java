package alkemy.challenge.Challenge.Alkemy.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor

public class PeliculaoSerieDto {
	
	private String imagen;
	
	private String titulo;
	
	private Date creationDate = new Date();

}
