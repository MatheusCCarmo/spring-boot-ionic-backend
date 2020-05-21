package com.matheusccarmo.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusccarmo.cursomc.domain.Categoria;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaResource {
	
	@GetMapping
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		List<Categoria> listaCat = new ArrayList<Categoria>();
		
		listaCat.add(cat1);
		listaCat.add(cat2);
		return listaCat;
	}
}
