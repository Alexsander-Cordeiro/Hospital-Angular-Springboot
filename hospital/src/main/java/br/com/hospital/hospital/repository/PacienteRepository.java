package br.com.hospital.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.hospital.hospital.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
	public List< Paciente > findAllByCodPaciente (Long codPaciente);

}
