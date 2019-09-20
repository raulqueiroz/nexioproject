package br.com.shopping.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(unique = true, nullable = false)
		private Long id;
		
		@Column(nullable = false)
		private Boolean ativo;
		
		@Column(nullable = false)
		private String login;
		
		@Column(nullable = false)
		private String nome;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Boolean getAtivo() {
			return ativo;
		}

		public void setAtivo(Boolean ativo) {
			this.ativo = ativo;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
}
