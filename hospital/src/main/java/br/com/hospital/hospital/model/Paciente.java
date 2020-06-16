package br.com.hospital.hospital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="paciente")
@Data
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codPaciente;
	
	private String nome;
	
	private String endereco;
	
	private String cep;
	
	private String telefone;

}
