package br.com.shopping.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.shopping.entity.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long> {

	Optional<Panier> findByUsuarioId(Long id);
	
	@Modifying
	@Query(value = "delete from panier_produit where id_produit =?1 and id_panier =?2", nativeQuery = true)
	void deletePanierProduit(Long idProduto, Long idPanier);

}
