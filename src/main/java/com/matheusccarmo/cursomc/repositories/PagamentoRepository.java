package com.matheusccarmo.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.matheusccarmo.cursomc.domain.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
