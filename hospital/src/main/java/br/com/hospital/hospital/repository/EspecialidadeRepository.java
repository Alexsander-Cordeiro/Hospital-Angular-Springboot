package br.com.hospital.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hospital.hospital.model.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long > {
	
	public List< Especialidade > findAllByCodEspecialidade (Long codEspecialidade);

}
