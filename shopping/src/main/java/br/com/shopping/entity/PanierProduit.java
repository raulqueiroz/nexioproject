package br.com.shopping.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "panier_produit")
public class PanierProduit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_produit")
	private Produit produto;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_panier")
	private Panier panier;
	
	private Integer quantidade;

	public Produit getProduto() {
		return produto;
	}

	public void setProduto(Produit produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

}
