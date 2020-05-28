package com.matheusccarmo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusccarmo.cursomc.domain.Categoria;
import com.matheusccarmo.cursomc.repositories.CategoriaRepository;
import com.matheusccarmo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() ->  new ObjectNotFoundException(String.format("Objeto não encontrado! ID:%d, TIPO: %s", id, Categoria.class.getName()))); 
	}
	
	public List<Categoria> listar() {
		List<Categoria> obj = repo.findAll();
		return obj; 
	}
	
	public void salvarTodos(List<Categoria> lista) {
		repo.saveAll(lista);
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		this.find(obj.getId());
		return repo.save(obj);
	}
	
}
