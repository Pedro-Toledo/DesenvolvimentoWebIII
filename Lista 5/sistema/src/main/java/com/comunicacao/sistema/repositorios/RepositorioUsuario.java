package com.comunicacao.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comunicacao.sistema.entitades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}