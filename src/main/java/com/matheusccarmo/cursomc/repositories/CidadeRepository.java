package com.matheusccarmo.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.matheusccarmo.cursomc.domain.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
