package com.matheusccarmo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusccarmo.cursomc.domain.Cliente;
import com.matheusccarmo.cursomc.repositories.ClienteRepository;
import com.matheusccarmo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() ->  new ObjectNotFoundException(String.format("Objeto não encontrado! ID:%d, TIPO: %s", id, Cliente.class.getName()))); 
	}
	
	public List<Cliente> listar() {
		List<Cliente> obj = repo.findAll();
		return obj; 
	}
	
	public void salvarTodos(List<Cliente> lista) {
		repo.saveAll(lista);
	}
	
}
