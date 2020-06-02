package com.matheusccarmo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.matheusccarmo.cursomc.domain.Categoria;
import com.matheusccarmo.cursomc.dto.CategoriaDTO;
import com.matheusccarmo.cursomc.repositories.CategoriaRepository;
import com.matheusccarmo.cursomc.services.exceptions.DataIntegrityException;
import com.matheusccarmo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() ->  new ObjectNotFoundException(String.format("Objeto não encontrado! ID:%d, TIPO: %s", id, Categoria.class.getName()))); 
	}
	
	public List<Categoria> findAll() {
		return repo.findAll();
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
	
	public void delete(Integer id) {
		this.find(id);
		try {
			repo.deleteById(id);			
		}catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível exlcuir uma categoria que possui produtos associados!");
		}
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO categoriaDTO) {
		return new Categoria(categoriaDTO.getId(), categoriaDTO.getNome());
	}
	
}
