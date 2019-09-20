package br.com.shopping.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "panier")
public class Panier implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@OneToMany(mappedBy = "panier", cascade = CascadeType.ALL)
	private List<PanierProduit> itensCesta;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Utilisateur usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PanierProduit> getItensCesta() {
		return itensCesta;
	}

	public void setItensCesta(List<PanierProduit> itensCesta) {
		this.itensCesta = itensCesta;
	}

	public Utilisateur getUsuario() {
		return usuario;
	}

	public void setUsuario(Utilisateur usuario) {
		this.usuario = usuario;
	}
	
	

}
