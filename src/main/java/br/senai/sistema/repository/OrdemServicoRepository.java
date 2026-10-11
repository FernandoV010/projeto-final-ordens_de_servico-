package br.senai.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.sistema.model.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
}