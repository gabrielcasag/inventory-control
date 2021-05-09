package com.gabrielcasag.estoque.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielcasag.estoque.apirest.models.Produto;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Long> {

}
