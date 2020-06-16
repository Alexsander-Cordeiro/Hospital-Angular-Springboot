package br.com.hospital.hospital.rest.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichaDTO {

	private Long idFicha;
	

	
	private Date dtConsulta;
	
	private Long valorConsulta;
	
	private String diagnostico;
	
	private String procedimento;
	
	private Date dtRetorno;
	
	private String exames;
	
	private Long crm;
	
	private Long codPaciente;
}
