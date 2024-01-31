package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.farmacia.model.Categoria;

// Herança com a JpaRepository (extends) <Categoria (classe/entidade que vai gerar a tabela a ser mapeada), Long (chave primária). 
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	// @Param --> define a variável titulo como parâmtro de consulta. 
	public List <Categoria> findAllByNomeContainingIgnoreCase(@Param("titulo") String titulo);
}
