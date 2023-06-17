package com.comunicacao.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comunicacao.sistema.entitades.Veiculo;

public interface RepositorioVeiculo extends JpaRepository<Veiculo, Long> {
}