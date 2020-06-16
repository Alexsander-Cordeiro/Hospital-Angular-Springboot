package br.com.hospital.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="medico")
@Data
public class Medico {
	

	 
	@Id 
	@Column(unique=true)
	@NotNull
	private long crm;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="cod_especialidade")
	private Especialidade especialidade;
}
