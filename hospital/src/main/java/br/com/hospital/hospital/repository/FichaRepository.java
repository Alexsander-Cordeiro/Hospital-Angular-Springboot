package br.com.hospital.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hospital.hospital.model.Ficha;

public interface FichaRepository extends JpaRepository< Ficha, Long > {
	
	public List< Ficha > findAllByIdFicha (long IdFicha);

}
