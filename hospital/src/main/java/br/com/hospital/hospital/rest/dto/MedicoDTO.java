package br.com.hospital.hospital.rest.dto;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class MedicoDTO {
	

	private Long crm;
	
	private String nome;
	
	private Long idEspecialidade;
	
	
}
