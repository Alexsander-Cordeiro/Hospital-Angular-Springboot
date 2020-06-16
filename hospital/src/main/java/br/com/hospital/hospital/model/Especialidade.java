package br.com.hospital.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="especialidades")
@Data
public class Especialidade {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codEspecialidade;
	
	@NotNull
	@Column
	private String nomeEspecialidade;

}
