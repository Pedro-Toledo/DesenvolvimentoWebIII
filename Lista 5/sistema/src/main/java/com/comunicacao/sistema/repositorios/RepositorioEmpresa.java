package com.comunicacao.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comunicacao.sistema.entitades.Empresa;

public interface RepositorioEmpresa extends JpaRepository<Empresa, Long> {
}