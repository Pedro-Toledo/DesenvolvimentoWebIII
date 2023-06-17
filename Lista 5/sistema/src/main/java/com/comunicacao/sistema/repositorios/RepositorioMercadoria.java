package com.comunicacao.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comunicacao.sistema.entitades.Mercadoria;

public interface RepositorioMercadoria extends JpaRepository<Mercadoria, Long> {
}