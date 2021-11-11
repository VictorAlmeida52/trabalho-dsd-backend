package br.unip.victor.iservicesbackend.servicos;

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
@RequestMapping("/servicos")
@AllArgsConstructor
public class ServicoController {

	@Autowired
	ServicoRepository repository;
	
	@GetMapping("/retornaTodos")
	List<Servico> todosPratos(){
		return repository.findAll();
	}
	
	@PostMapping("/novo")
	Servico novoPrato(@RequestBody Servico prato) {
		return repository.save(prato);
	}
	
	@GetMapping("/{id}")
	Optional<Servico> retornaPrato(@PathVariable Long id){
		return repository.findById(id);
	}
	
	@PutMapping("/{id}")
	Servico atualizaPrato(@RequestBody Servico prato, @PathVariable Long id) {
		prato.setId(id);
		return repository.save(prato);
	}
	
	@DeleteMapping("/deleta/{id}")
	void deletaPrato(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/retornaTodosDoPrestador/{id}")
	List<Servico> todosServicosDoPrestador(@PathVariable Long id){
		return repository.findAllByPrestadorId(id);
	}
	
}
