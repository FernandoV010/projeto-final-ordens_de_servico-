package br.senai.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.sistema.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}