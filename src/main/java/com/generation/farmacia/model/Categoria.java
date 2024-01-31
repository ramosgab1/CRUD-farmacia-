package com.generation.farmacia.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // Define uma entidade --> Gera a tabela. 
@Table(name = "tb_categorias") // Nomeia a tabela criada acima.
public class Categoria {

	// Aqui coloca-se os atributos a serem utilizados. 
	// Os mais importantes: ID, Nome, Descrição.
	
	// ATRIBUTO ID 
	@Id // Indica a chave primária. 
	@GeneratedValue(strategy =  GenerationType.IDENTITY) // Indica que será gerada pelo banco de dados c/ auto-incremento. 
	private Long id;
	
	// ATRIBUTO NOME 
	@NotBlank(message = "O nome da categoria não pode ser nulo ou em branco.") // Não permite espaços nulos ou em branco. 
	@Size(min = 5, max = 100, message = "O nome da categoria deve ter no mínimo 05 e no máximo 100 caracteres.")
	private String nome; 
	
	// ATRIBUTO DESCRIÇÃO
	@NotBlank(message = "A descrição da categoria não pode ser nula ou em branco.")
	@Size(min = 5, max = 255, message = "A descrição da categoria deve ter no mínimo 05 e no máximo 255 caracteres.")
	private String descricao;
	
	// RELAÇÃO ONE TO MANY COM PRODUTO (uma categoria para vários produtos --> 1:N).   
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto; 
	
	// GERAÇÃO DE GETTERS E SETTERS. 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricaocategoria(String descricao) {
		this.descricao = descricao;
	}

	// GETTERS E SETTERS DE PRODUTO 
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
}