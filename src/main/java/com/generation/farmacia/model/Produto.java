package com.generation.farmacia.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // Define uma entidade --> Gera a table.
@Table(name = "tb_produtos") // Nomeia a tabela criada acima. 
public class Produto {

	// Aqui coloca-se os atributos a serem utilizados. 
	// Os mais importantes: ID do produto, Nome, Descrição
	// Preço, Imagem, Categoria, Disponibilidade em Estoque.
	
	
	// ATRIBUTO ID 
	@Id // Indica a chave Primária. 
	@GeneratedValue(strategy= GenerationType.IDENTITY) // Indica que será gerada pelo banco de dados c/ auto-incremento. 
	private Long id; 

	// ATRIBUTO NOME 
	@NotBlank (message = "O nome do produto é obrigatório.") // Não permite nulo ou espaços em branco. 
	@Size(min = 5, max = 100, message = "O nome do produto deve conter no mínimo 05 e no máximo 100 caracteres.")
	private String nome; 
	
	// ATRIBUTO DESCRIÇÃO 
	@NotBlank(message = "A descrição do produto é obrigatória.")
	@Size(min = 5, max = 255, message = "A descrição do produto deve ter no mínimo 05 e no máximo 255 caracteres.")
	private String descricao;
	
	// ATRIBUTO PREÇO 
	@NotBlank(message = "O preço do produto é obrigatório.")
	@DecimalMin(value = "0.01", message = "O preço do produto deve ser maior que zero.") // Especifica valor mínimo permitido (evita preços negativos). 
	@Digits(integer = 6, fraction = 2, message = "O preço dos produtos deve ter no máximo 06 dígitos inteiros e 02 decimais.") // Define número máximo de dígitos inteiros e decimais permitidos. 
	private BigDecimal preco; 
	
	// ATRIBUTO IMAGEM (imagem = link então String). 
	@Size(max = 500, message = "O link da imagem deve conter no máximo 500 caracteres.")
	private String imagem; 
	
	// ATRIBUTO CATEGORIA (Chave estrangeira, lembrar relação MANY TO ONE).
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria; 
	
	// ATRIBUTO DISPONIBILIDADE 
	@NotBlank(message = "Deve ser informado se o produto está ou não em estoque.")
	@Size(max = 15, message ="O máximo de caracteres utilizáveis é 15. Usar 'EM ESTOQUE' ou 'EM FALTA'.")
	private String disponibilidade;

	// Getters e Setters. 
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

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	} 
	
}