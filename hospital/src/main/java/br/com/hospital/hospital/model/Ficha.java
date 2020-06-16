package br.com.hospital.hospital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="ficha")
@Data
public class Ficha {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFicha;
	
	 
	@ManyToOne
	@JoinColumn(name="crm")
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="cod_paciente")
	private Paciente paciente;
	
	@Column
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtConsulta = new java.sql.Date(System.currentTimeMillis());
	
	@Column
	private Long valorConsulta;
	
	@Column
	private String diagnostico;
	
	@Column
	private String procedimento;
	
	@Column
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtRetorno = new java.sql.Date(System.currentTimeMillis());
	
	@Column
	private String exames;
	

}
