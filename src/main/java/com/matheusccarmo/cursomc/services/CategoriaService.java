package com.matheusccarmo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusccarmo.cursomc.domain.Categoria;
import com.matheusccarmo.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null); 
	}
	
	public List<Categoria> listar() {
		List<Categoria> obj = repo.findAll();
		return obj; 
	}
	
}
