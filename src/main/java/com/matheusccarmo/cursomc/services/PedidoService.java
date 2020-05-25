package com.matheusccarmo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusccarmo.cursomc.domain.Pedido;
import com.matheusccarmo.cursomc.repositories.PedidoRepository;
import com.matheusccarmo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() ->  new ObjectNotFoundException(String.format("Objeto não encontrado! ID:%d, TIPO: %s", id, Pedido.class.getName()))); 
	}
	
	public List<Pedido> listar() {
		List<Pedido> obj = repo.findAll();
		return obj; 
	}
	
	public void salvarTodos(List<Pedido> lista) {
		repo.saveAll(lista);
	}
	
}
