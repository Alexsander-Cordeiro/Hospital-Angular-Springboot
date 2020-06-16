package br.com.hospital.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.hospital.hospital.model.Medico;

public interface MedicoRepository  extends JpaRepository< Medico,Long >{

	public List< Medico > findAllByCrm (Long Crm);
}
