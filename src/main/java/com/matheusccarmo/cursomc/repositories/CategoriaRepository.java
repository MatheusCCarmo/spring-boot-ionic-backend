package com.matheusccarmo.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.matheusccarmo.cursomc.domain.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
