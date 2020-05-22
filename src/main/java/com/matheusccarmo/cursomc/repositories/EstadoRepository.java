package com.matheusccarmo.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.matheusccarmo.cursomc.domain.Estado;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
