package br.unip.victor.iservicesbackend.prestadores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/prestadores")
@AllArgsConstructor
public class PrestadorController {

	@Autowired
	PrestadorRepository repository;
	
	@GetMapping("/retornaTodos")
	List<Prestador> todosRestaurantes(){
		return repository.findAll();
	}
	
	@PostMapping("/novo")
	Prestador novoRestaurante(@RequestBody Prestador prestador) {
		return repository.save(prestador);
	}
	
	@GetMapping("/{id}")
	Optional<Prestador> retornaRestaurante(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	@PutMapping("/{id}")
	Prestador atualizaRestaurante(@RequestBody Prestador restaurante, @PathVariable Long id) {
		
		restaurante.setId(id);
		return repository.save(restaurante);
		
	}
	
	@DeleteMapping("/deleta/{id}")
	void deletaRestaurante(@PathVariable Long id) {
		repository.deleteById(id);
	}

	
}
