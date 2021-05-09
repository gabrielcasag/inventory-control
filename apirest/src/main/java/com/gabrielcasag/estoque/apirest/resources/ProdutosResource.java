package com.gabrielcasag.estoque.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielcasag.estoque.apirest.models.Produto;
import com.gabrielcasag.estoque.apirest.repository.ProdutosRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProdutosResource {

	@Autowired
	private ProdutosRepository repo;
	
	@GetMapping("/produtos")
	@CrossOrigin
	public List<Produto> listar() {
		return repo.findAll();
	}
	
	@PostMapping("/produto")
	@CrossOrigin
	public Produto cadastrar(@RequestBody Produto novoProduto) {
		return repo.save(novoProduto);
	}
	
	@DeleteMapping("/produto")
	@CrossOrigin
	public void deletar(@RequestBody Produto umProduto) {
		repo.delete(umProduto);
	}
	
	@PutMapping("/produto")
	@CrossOrigin
	public Produto atualizar(@RequestBody Produto umProduto) {
		return repo.save(umProduto);
	}
	
}
