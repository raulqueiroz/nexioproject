package br.com.shopping.to;

import java.util.List;

public class PanierDTO {

	private List<PanierProduitDTO> itensCesta;

	public List<PanierProduitDTO> getItensCesta() {
		return itensCesta;
	}

	public void setItensCesta(List<PanierProduitDTO> itensCesta) {
		this.itensCesta = itensCesta;
	}
	
}
