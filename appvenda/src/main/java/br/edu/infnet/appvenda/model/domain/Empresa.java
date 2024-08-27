package br.edu.infnet.appvenda.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TEmpresa",
      uniqueConstraints = {
    		  @UniqueConstraint(columnNames = {"cnpj"}),
    		  @UniqueConstraint(columnNames = {"gmail"})
    		  })
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 2, max = 50)
	private String razaoSocial;
	
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
	@Column(unique = true)
	private String cnpj;
	
	@Size(min = 2, max = 50)
	@Column(unique = true)
	private String gmail;
	
	@OneToMany
	@JoinColumn(name = "idEmpresa")
	private List<Produto> produtos;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	@Override
	public String toString() {
		return String.format("id (%d) - razaoSocial (%s) - cnpj (%s) - gmail (%s) - endereco (%s) - produtos (%d)",
				id,
				razaoSocial,
				cnpj,
				gmail,
				endereco,
				produtos != null ? produtos.size() : 0);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String nome) {
		this.razaoSocial = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cpf) {
		this.cnpj = cpf;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String email) {
		this.gmail = email;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}