package br.com.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.shopping.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

}
