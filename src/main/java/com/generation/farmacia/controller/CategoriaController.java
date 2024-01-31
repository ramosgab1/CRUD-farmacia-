package com.generation.farmacia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.farmacia.model.Categoria;
import com.generation.farmacia.repository.CategoriaRepository;

import jakarta.validation.Valid;

@RestController // Define a classe como do tipo RestController.
@RequestMapping("/categorias") // Mapeia as solicitações para os métodos da classe Controller.
@CrossOrigin(origins = "*", allowedHeaders = "*") // Permite o recebimento de requisições de fora do domínio. 
public class CategoriaController {

	@Autowired // Injeção de Dependência, insere uma classe dentro da outra e inverte o controle. 
	private CategoriaRepository categoriaRepository; 
	
	// MÉTODO - VER TODOS (GET). 
	@GetMapping 
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	// MÉTODO - VER POR ID (GET). 
	@GetMapping("/{id}") // Mapeia requisições GET para o endpoint /{id} 
	public ResponseEntity<Categoria> getById(@PathVariable Long id){ // ResponseEntity -> responde requisições. @PathVariable substitui.
		return categoriaRepository.findById(id)
		.map (resposta -> ResponseEntity.ok(resposta)) // Expressão lambda (argumento) -> (corpo). 
		.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	// MÉTODO - VER POR NOME (GET). 
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(categoriaRepository.findAllByNomeContainingIgnoreCase(nome));
	}

	// MÉTODO - CADASTRAR CATEGORIA (POST). 
	@PostMapping // Equivalente ao INSERT INTO do MySQL.
	public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(categoriaRepository.save(categoria));
	}
	
	// MÉTODO - ATUALIZAR POSTAGEM (PUT).
	@PutMapping
	public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria){
		return categoriaRepository.findById(categoria.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
					.body(categoriaRepository.save(categoria)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	// MÉTODO - DELETAR CATEGORIA (DELETE). 
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}") // Equivalente ao DELETE FROM do MySQL.
	public void delete(@PathVariable Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		if(categoria.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		categoriaRepository.deleteById(id);
	}
}

