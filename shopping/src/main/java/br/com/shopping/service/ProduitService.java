package br.com.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.shopping.dao.ProduitRepository;
import br.com.shopping.entity.Produit;

@Service
public class ProduitService {
	
	@Autowired
	private ProduitRepository produtoRepository;
	

	public void salvar(Produit produto){
		produtoRepository.save(produto);
	}

	public List<Produit> listar(){
		return produtoRepository.findAll();
	}

	public void delete(Long id) {
		produtoRepository.deleteById(id);		
	}

	public void atualizar(Produit produto) {
		produtoRepository.save(produto);		
	}
	
	public Produit detalharProduto(Long id){
		Produit produit = null;
		Optional<Produit> opt = produtoRepository.findById(id);
		
		if(opt.isPresent()) {
			produit = new Produit();
			produit.setId(opt.get().getId());
			produit.setDescricao(opt.get().getDescricao());
			produit.setValor(opt.get().getValor());
		}
		
		return produit;
	}
	
}
