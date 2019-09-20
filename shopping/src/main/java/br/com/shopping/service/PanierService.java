package br.com.shopping.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.shopping.dao.PanierRepository;
import br.com.shopping.entity.Panier;
import br.com.shopping.entity.PanierProduit;
import br.com.shopping.entity.Produit;
import br.com.shopping.entity.Utilisateur;
import br.com.shopping.to.PanierDTO;
import br.com.shopping.to.PanierProduitDTO;

@Service
public class PanierService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PanierRepository panierRepository;


	public PanierDTO listar(Long idUsuario) {
		Panier panier = panierRepository.findByUsuarioId(idUsuario).orElse(new Panier());
		PanierDTO panierDTO = new PanierDTO();
		List<PanierProduitDTO> itensCesta = new ArrayList<>();

		if (panier.getItensCesta() != null) {
			for (PanierProduit panierProduit : panier.getItensCesta()) {
				PanierProduitDTO panierProduitDTO = new PanierProduitDTO();
				panierProduitDTO.setIdProduto(panierProduit.getProduto().getId());
				panierProduitDTO.setQuantidade(panierProduit.getQuantidade());
				itensCesta.add(panierProduitDTO);
			}
		}
		panierDTO.setItensCesta(itensCesta);

		return panierDTO;

	}

	public void salvar(Long idUsuario, Long idProduto, Integer quantidade) {
		Panier panier = panierRepository.findByUsuarioId(idUsuario).orElse(new Panier());

		Produit produto = new Produit();
		produto.setId(idProduto);

		PanierProduit panierProduto = new PanierProduit();
		panierProduto.setQuantidade(quantidade);
		panierProduto.setProduto(produto);
		panierProduto.setPanier(panier);

		Utilisateur usuario = new Utilisateur();
		usuario.setId(idUsuario);
		panier.setUsuario(usuario);

		if (panier.getItensCesta() == null) {
			panier.setItensCesta(new ArrayList<>());
		}

		panier.getItensCesta().add(panierProduto);
		panierRepository.save(panier);
	}

	public void delete(Long idProduto, Long idPanier) {

		panierRepository.deletePanierProduit(idProduto, idPanier);
	}

}
