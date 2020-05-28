package com.matheusccarmo.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusccarmo.cursomc.domain.Cliente;
import com.matheusccarmo.cursomc.services.ClienteService;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> obj = service.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Cliente> find(@PathVariable int id) {
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
