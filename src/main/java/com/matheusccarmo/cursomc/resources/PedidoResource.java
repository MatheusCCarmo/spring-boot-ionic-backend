package com.matheusccarmo.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusccarmo.cursomc.domain.Pedido;
import com.matheusccarmo.cursomc.services.PedidoService;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> listar() {
		List<Pedido> obj = service.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Pedido> find(@PathVariable int id) {
		Pedido obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
