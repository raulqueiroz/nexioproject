package br.com.shopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.shopping.entity.Panier;
import br.com.shopping.service.PanierService;
import br.com.shopping.to.PanierDTO;
import br.com.shopping.to.PanierProduitDTO;
import io.swagger.annotations.ApiOperation;

@RestController
public class PanierController {

	@Autowired
	private PanierService panierService;

	@PostMapping(value = "v1/private/panier")
	@ApiOperation(value = "Ajouter un produit au panier")
	public ResponseEntity<Void> save(@Valid @RequestBody PanierProduitDTO panierProdutoTO, Long idUsuario) {
		panierService.salvar(idUsuario, panierProdutoTO.getIdProduto(), panierProdutoTO.getQuantidade());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping(value = "v1/private/panier")
	@ApiOperation(value = "Afficher le contenu du panier")
	public ResponseEntity<PanierDTO> listAllByUser(Long idUsuario) {
		return new ResponseEntity<PanierDTO>(panierService.listar(idUsuario), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "v1/private/panier/{idproduto}/{idpanier}")
	@ApiOperation(value = "Enlever un produit du panier")
	public ResponseEntity<Void> delete(@PathVariable("idproduto") Long idProduto, @PathVariable("idpanier") Long idPanier) {
		panierService.delete(idProduto, idPanier);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
