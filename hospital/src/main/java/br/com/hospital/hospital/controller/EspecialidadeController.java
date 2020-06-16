package br.com.hospital.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


import br.com.hospital.hospital.model.Especialidade;
import br.com.hospital.hospital.repository.EspecialidadeRepository;

@RestController
@RequestMapping("/especialidades")
@CrossOrigin("*")
public class EspecialidadeController {

	@Autowired
	private EspecialidadeRepository repository;
	

		
		@GetMapping("/{codEspecialidade}")
		public ResponseEntity<Especialidade> GetById(@PathVariable long codEspecialidade){
			return repository.findById(codEspecialidade)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
		}

		@GetMapping
		public ResponseEntity<List<Especialidade>> GetAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		

		
		@PostMapping
		public ResponseEntity<Especialidade> post (@RequestBody Especialidade especialidade) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(especialidade));
		}
		@PutMapping
		public ResponseEntity<Especialidade> put (@RequestBody Especialidade especialidade){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(especialidade));
		}

		@DeleteMapping("/{codEspecialidade}")
		public void delete(@PathVariable long codEspecialidade) {
			repository.deleteById(codEspecialidade);
		}
	
}
