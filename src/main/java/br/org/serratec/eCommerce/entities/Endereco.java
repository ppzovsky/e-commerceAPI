package br.org.serratec.eCommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "endereco_id")
	private Integer enderecoId;
	
	@OneToOne(mappedBy = "endereco")
	@JsonBackReference
	private Cliente cliente;
	
	@NotBlank
	@Column(name = "cep")
	private String cep;
	
	@NotBlank
	@Column(name = "rua")
	private String rua;
	
	@NotBlank
	@Column(name = "bairro")
	private String bairro;
	
	@NotBlank
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "complemento")
	private String complemento;
	
	@Size(min = 2, max = 2)
	@NotBlank
	@Column(name = "uf")
	private String uf;
	
	public Endereco() {
	}

	public Endereco(Integer idEndereco, String cep, String rua, String bairro, String cidade, int numero,
			String complemento, String uf) {
		super();
		this.enderecoId = idEndereco;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.complemento = complemento;
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}