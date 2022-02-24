package com.produtos.apirestwba.Controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.type.descriptor.java.PrimitiveCharacterArrayTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirestwba.model.Produto;
import com.produtos.apirestwba.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	//Todos itens da lista
	@GetMapping(value = "/")
	public List<Produto> listaCompleta(){
		
		return(List<Produto>)produtoRepository.findAll();
	}
	
	//Lista pelo ID
	@GetMapping(value = "/{id}")
	public Optional<Produto> listaId(@PathVariable(value = "id") Long id){
		
		return produtoRepository.findById(id);
	}
	
	//Salvar
	@PostMapping(value = "/")
	public Produto salvar(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
		
	}
	//Atualizar
	@PutMapping(value = "/")
	public Produto atualizar(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
		
	}
	//Deletar
	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long id) {
		
		  produtoRepository.deleteById(id);
		
	}

}
