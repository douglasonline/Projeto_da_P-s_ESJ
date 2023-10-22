package br.edu.infnet.appvenda.model.domain;

public class Roupas extends Produto {

	private String tipo;
	private String cor;

	@Override
	public String toString() {
		return String.format("%s - %s - %s", super.toString(), tipo, cor);
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
}