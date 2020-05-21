package com.matheusccarmo.cursomc;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheusccarmo.cursomc.domain.Categoria;
import com.matheusccarmo.cursomc.services.CategoriaService;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaService categoriaService;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");	
		Categoria cat2 = new Categoria(null, "Escritório");
		
		List<Categoria> lista = Arrays.asList(cat1, cat2);
		
		categoriaService.salvarTodos(lista);
	}

}
