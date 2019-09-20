package br.com.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.shopping.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
