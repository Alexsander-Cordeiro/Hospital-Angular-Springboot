package br.com.hospital.hospital.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.hospital.hospital.model.Ficha;
import br.com.hospital.hospital.model.Medico;
import br.com.hospital.hospital.model.Paciente;
import br.com.hospital.hospital.repository.FichaRepository;
import br.com.hospital.hospital.repository.MedicoRepository;
import br.com.hospital.hospital.repository.PacienteRepository;
import br.com.hospital.hospital.rest.dto.FichaDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fichas")
@CrossOrigin("*")
@RequiredArgsConstructor
public class FichaController {
	
	private final PacienteRepository pacienteRepository;
	private final MedicoRepository medicoRepository;
	private final FichaRepository repository;
	 
	@PostMapping
	public Ficha salvar (@RequestBody FichaDTO dto) {
		long crm = dto.getCrm();
		long codPaciente = dto.getCodPaciente();
		
		Medico medico = 
				medicoRepository.findById(crm)
				.orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Médico Inexistente."));
		Paciente paciente = 
				pacienteRepository.findById(codPaciente)
				.orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Paciente Inexistente."));
		
		Ficha ficha = new Ficha();
		ficha.setPaciente(paciente); 
		ficha.setMedico(medico);
		ficha.setDiagnostico(dto.getDiagnostico());
		ficha.setExames(dto.getExames());
		ficha.setProcedimento(dto.getProcedimento());
		ficha.setValorConsulta(dto.getValorConsulta());
		
		
		return repository.save(ficha);
	}
	
	 
		
		@GetMapping("/{idFicha}")
		public ResponseEntity<Ficha> GetById(@PathVariable long idFicha){
			return repository.findById(idFicha)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
		}
 
		@GetMapping
		public ResponseEntity<List<Ficha>> GetAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		

		 
		/*@PostMapping
		public ResponseEntity<Ficha> post (@RequestBody Ficha ficha) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(ficha));
		}*/
		@PutMapping
		public ResponseEntity<Ficha> put (@RequestBody Ficha ficha){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(ficha));
		}

		@DeleteMapping("/{idFicha}")
		public void delete(@PathVariable long idFicha) {
			repository.deleteById(idFicha);
		}
	
}
