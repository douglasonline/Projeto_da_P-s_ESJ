package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TRoupas")
public class Roupas extends Produto {

	@Size(min = 2, max = 100, message = "A característica deve ter entre {min} e {max} caracteres.")
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