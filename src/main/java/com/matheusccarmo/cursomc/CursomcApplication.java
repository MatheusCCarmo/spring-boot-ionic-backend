package com.matheusccarmo.cursomc;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheusccarmo.cursomc.domain.Categoria;
import com.matheusccarmo.cursomc.domain.Cidade;
import com.matheusccarmo.cursomc.domain.Estado;
import com.matheusccarmo.cursomc.domain.Produto;
import com.matheusccarmo.cursomc.repositories.CidadeRepository;
import com.matheusccarmo.cursomc.repositories.EstadoRepository;
import com.matheusccarmo.cursomc.services.CategoriaService;
import com.matheusccarmo.cursomc.services.ProdutoService;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");	
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		List<Categoria> listaCat = Arrays.asList(cat1, cat2);
		List<Produto> listaProd = Arrays.asList(p1, p2, p3);
				
		categoriaService.salvarTodos(listaCat);
		produtoService.salvarTodos(listaProd);		
		
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
	
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}

}
