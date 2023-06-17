package com.comunicacao.api.controles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.comunicacao.api.entitades.Empresa;
import com.comunicacao.api.entitades.Mercadoria;
import com.comunicacao.api.entitades.Usuario;
import com.comunicacao.api.entitades.Veiculo;
import com.comunicacao.api.entitades.Venda;

@RestController
public class ControleUsuario {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/todos-usuarios")
	public ResponseEntity<?> obterUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();

		ResponseEntity<? extends List> resposta = new RestTemplate()
				.getForEntity("http://localhost:8080/usuarios", usuarios.getClass());
		usuarios = resposta.getBody();
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.FOUND);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/usuarios-empresa")
	public ResponseEntity<?> obterUsuariosEmpresa(@RequestBody String empresaEscolhida) {
		List<Usuario> usuarios = new ArrayList<>();
		List<Empresa> empresas = new ArrayList<>();
		List<Usuario> usuariosEmpresa = new ArrayList<>();

		ResponseEntity<? extends List> resposta = new RestTemplate()
				.getForEntity("http://localhost:8080/usuarios", usuarios.getClass());
		usuarios = resposta.getBody();
		ResponseEntity<? extends List> resposta2 = new RestTemplate()
				.getForEntity("http://localhost:8080/empresa", empresas.getClass());
		empresas = resposta2.getBody();
		for(Empresa empresa: empresas){
			if(empresa.getNomeFantasia() == empresaEscolhida){
				for(Usuario usuario: empresa.getUsuarios()) {
					for(Usuario usuario2: usuarios) {
						if(usuario.getId() == usuario2.getId()){
							usuariosEmpresa.add(usuario2);
						}
					}
				}
			}
		}
		
		return new ResponseEntity<List<Usuario>>(usuariosEmpresa, HttpStatus.FOUND);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/funcionaris-empresa")
	public ResponseEntity<?> obterFuncionariosEmpresa(@RequestBody String empresaEscolhida) {
		List<Usuario> usuarios = new ArrayList<>();
		List<Empresa> empresas = new ArrayList<>();
		List<Usuario> funcionariosEmpresa = new ArrayList<>();

		ResponseEntity<? extends List> resposta = new RestTemplate()
				.getForEntity("http://localhost:8080/usuarios", usuarios.getClass());
		usuarios = resposta.getBody();
		ResponseEntity<? extends List> resposta2 = new RestTemplate()
				.getForEntity("http://localhost:8080/empresa", empresas.getClass());
		empresas = resposta2.getBody();
		for(Empresa empresa: empresas){
			if(empresa.getNomeFantasia() == empresaEscolhida){
				for(Usuario usuario: empresa.getUsuarios()) {
					if(usuario.getTipoUsuario() == "FUNCIONARIO") {
						for(Usuario usuario2: usuarios) {
							if(usuario.getId() == usuario2.getId()){
								funcionariosEmpresa.add(usuario2);
							}
						}
					}
				}
			}
		}
		
		return new ResponseEntity<List<Usuario>>(funcionariosEmpresa, HttpStatus.FOUND);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/mercadorias-empresa")
	public ResponseEntity<?> obterMercadoriasEmpresa(@RequestBody String empresaEscolhida) {
		List<Mercadoria> mercadorias = new ArrayList<>();
		List<Empresa> empresas = new ArrayList<>();
		List<Mercadoria> mercadoriasEmpresa = new ArrayList<>();

		ResponseEntity<? extends List> resposta = new RestTemplate()
				.getForEntity("http://localhost:8080/empresa", empresas.getClass());
		empresas = resposta.getBody();
		ResponseEntity<? extends List> resposta2 = new RestTemplate()
				.getForEntity("http://localhost:8080/mercadoria", mercadorias.getClass());
		mercadorias = resposta2.getBody();
		for(Empresa empresa: empresas){
			if(empresa.getNomeFantasia() == empresaEscolhida){
				for(Mercadoria mercadoria: empresa.getMercadorias()){
					for(Mercadoria mercadoria2: mercadorias) {
						if(mercadoria.getId() == mercadoria2.getId()){
							mercadoriasEmpresa.add(mercadoria2);
						}
					}
				}
			}
		}
		return new ResponseEntity<List<Mercadoria>>(mercadoriasEmpresa, HttpStatus.FOUND);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/veiculos-empresa")
	public ResponseEntity<?> obterVeiculoEmpresa(@RequestBody String empresaEscolhida) {
		List<Veiculo> veiculos = new ArrayList<>();
		List<Empresa> empresas = new ArrayList<>();
		List<Veiculo> veiculosEmpresa = new ArrayList<>();

		ResponseEntity<? extends List> resposta = new RestTemplate()
				.getForEntity("http://localhost:8080/empresa", empresas.getClass());
		empresas = resposta.getBody();
		ResponseEntity<? extends List> resposta2 = new RestTemplate()
				.getForEntity("http://localhost:8080/veiculos", veiculos.getClass());
		veiculos = resposta2.getBody();
		for(Empresa empresa: empresas){
			if(empresa.getNomeFantasia() == empresaEscolhida){
				for(Venda venda: empresa.getVendas()){
					for(Veiculo veiculo: veiculos) {
						if(venda.getVeiculo() == veiculo){
							veiculosEmpresa.add(veiculo);
						}
					}
				}
			}
		}
		return new ResponseEntity<List<Veiculo>>(veiculosEmpresa, HttpStatus.FOUND);
	}
}