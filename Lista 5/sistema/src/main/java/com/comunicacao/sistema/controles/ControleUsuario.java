package com.comunicacao.sistema.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comunicacao.sistema.entitades.Empresa;
import com.comunicacao.sistema.entitades.Mercadoria;
import com.comunicacao.sistema.entitades.Usuario;
import com.comunicacao.sistema.entitades.Veiculo;
import com.comunicacao.sistema.repositorios.RepositorioEmpresa;
import com.comunicacao.sistema.repositorios.RepositorioMercadoria;
import com.comunicacao.sistema.repositorios.RepositorioUsuario;
import com.comunicacao.sistema.repositorios.RepositorioVeiculo;

@RestController
public class ControleUsuario {
	@Autowired
	private RepositorioUsuario repositorio;
	@Autowired
	private RepositorioEmpresa repositorio2;
	@Autowired
	private RepositorioMercadoria repositorio3;
	@Autowired
	private RepositorioVeiculo repositorio4;

	@GetMapping("/usuarios")
	public ResponseEntity<?> obterUsuarios() {
		List<Usuario> usuarios = repositorio.findAll();
		return new ResponseEntity<>(usuarios, HttpStatus.FOUND);
	}

	@GetMapping("/empresa")
	public ResponseEntity<?> obterEmpresa() {
		List<Empresa> empresas = repositorio2.findAll();
		return new ResponseEntity<>(empresas, HttpStatus.FOUND);
	}

	@GetMapping("/mercadoria")
	public ResponseEntity<?> obterMercadoria() {
		List<Mercadoria> mercadorias = repositorio3.findAll();
		return new ResponseEntity<>(mercadorias, HttpStatus.FOUND);
	}

	@GetMapping("/veiculo")
	public ResponseEntity<?> obterVeiculo() {
		List<Veiculo> veiculos = repositorio4.findAll();
		return new ResponseEntity<>(veiculos, HttpStatus.FOUND);
	}
}