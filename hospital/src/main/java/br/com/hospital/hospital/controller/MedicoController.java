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

import br.com.hospital.hospital.model.Especialidade;
import br.com.hospital.hospital.model.Medico;
import br.com.hospital.hospital.repository.EspecialidadeRepository;
import br.com.hospital.hospital.repository.MedicoRepository;
import br.com.hospital.hospital.rest.dto.MedicoDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/medicos")
@CrossOrigin("*")
@RequiredArgsConstructor
public class MedicoController {

		private final EspecialidadeRepository especialidadeRepository;
		private final MedicoRepository repository;
		 
		@PostMapping
		public Medico salvar (@RequestBody MedicoDTO dto) {
			long idEspecialidade = dto.getIdEspecialidade();
			
			Especialidade especialidade = 
					especialidadeRepository.findById(idEspecialidade)
					.orElseThrow(()->
					new ResponseStatusException(HttpStatus.BAD_REQUEST, "Especialidade Inexistente."));
			
			Medico medico = new Medico();
			medico.setEspecialidade(especialidade);
			medico.setCrm(dto.getCrm());
			medico.setNome(dto.getNome());
			
			return repository.save(medico);
		}
	
		
		@GetMapping("/{crm}")
		public ResponseEntity<Medico> GetById(@PathVariable long crm){
			return repository.findById(crm)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
		}

		@GetMapping
		public ResponseEntity<List<Medico>> GetAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		

		  
		/*@PostMapping
		public ResponseEntity<Medico> post (@RequestBody Medico medico) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(medico));
		}*/
		@PutMapping
		public Medico editar (@RequestBody MedicoDTO dto) {
			long idEspecialidade = dto.getIdEspecialidade();
			
			Especialidade especialidade = 
					especialidadeRepository.findById(idEspecialidade)
					.orElseThrow(()->
					new ResponseStatusException(HttpStatus.BAD_REQUEST, "Especialidade Inexistente."));
			
			Medico medico = new Medico();
			medico.setEspecialidade(especialidade);
			medico.setCrm(dto.getCrm());
			medico.setNome(dto.getNome());
			
			return repository.save(medico);
		}
		/*@PutMapping
		public ResponseEntity<Medico> put (@RequestBody Medico medico){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(medico));
		}*/

		@DeleteMapping("/{crm}")
		public void delete(@PathVariable long crm) {
			repository.deleteById(crm);
		}
	
}
