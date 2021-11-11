package br.unip.victor.iservicesbackend.servicos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

	List<Servico> findAllByPrestadorId(Long id);
	
}
