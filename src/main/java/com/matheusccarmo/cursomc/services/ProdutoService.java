package com.matheusccarmo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusccarmo.cursomc.domain.Produto;
import com.matheusccarmo.cursomc.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	public Produto buscar(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null); 
	}
	
	public List<Produto> listar() {
		List<Produto> obj = repo.findAll();
		return obj; 
	}
	
	public void salvarTodos(List<Produto> lista) {
		repo.saveAll(lista);
	}
	
}
