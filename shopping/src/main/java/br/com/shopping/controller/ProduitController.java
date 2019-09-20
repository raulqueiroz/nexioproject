package br.com.shopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.shopping.entity.Produit;
import br.com.shopping.service.ProduitService;
import io.swagger.annotations.ApiOperation;

@RestController
public class ProduitController {
	
	@Autowired
	private ProduitService produtoService;

	@PostMapping(value = "v1/private/produit")
	@ApiOperation(value = "Ajouter un produit")
	public ResponseEntity<Void> save(@Valid @RequestBody Produit produto) {
		produtoService.salvar(produto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
		
	@GetMapping(value = "v1/private/produit")
	@ApiOperation(value = "Afficher un catalogue de produits")
	public ResponseEntity<List<Produit>> listAllByUser() {
		return new ResponseEntity<List<Produit>>(produtoService.listar(), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "v1/private/produit/{id}")
	@ApiOperation(value = "Afficher le détail d’un produit")
	public ResponseEntity<Produit> listByUser(@PathVariable("id") Long id) {
		return new ResponseEntity<Produit>(produtoService.detalharProduto(id), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "v1/private/produit/{id}")
	@ApiOperation(value = "Enlever un produit")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		produtoService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "v1/private/produit")
	@ApiOperation(value = "mettre à jour un nouveau produit.")
	public ResponseEntity<Void> update(@Valid @RequestBody Produit produto) {
		produtoService.atualizar(produto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	


}
