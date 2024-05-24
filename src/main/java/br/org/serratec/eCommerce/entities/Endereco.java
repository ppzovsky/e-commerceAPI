package br.org.serratec.eCommerce.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    @JsonAlias("cep")
    private String cep;

    @Column(name = "rua")
    @JsonAlias("logradouro")
    private String rua;

    @Column(name = "bairro")
    @JsonAlias("bairro")
    private String bairro;

    @Column(name = "cidade")
    @JsonAlias("localidade")
    private String cidade;

    @Column(name = "numero")
    private int numero;

    @Column(name = "complemento")
    private String complemento;

    @Size(min = 2, max = 2)
    @Column(name = "uf")
    @JsonAlias("uf")
    private String uf;

    
    
    public Endereco() {
		super();
	}
    
  

	public Endereco(Integer enderecoId, Cliente cliente, @NotBlank String cep, String rua, String bairro, String cidade,
			int numero, String complemento, @Size(min = 2, max = 2) String uf) {
		super();
		this.enderecoId = enderecoId;
		this.cliente = cliente;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.complemento = complemento;
		this.uf = uf;
	}



	// Getters and Setters

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

//    public void preencherDados(Endereco enderecoViaCep) {
//        this.cep = enderecoViaCep.getCep();
//        this.uf = enderecoViaCep.getUf();
//        this.cidade = enderecoViaCep.getCidade();
//        this.bairro = enderecoViaCep.getBairro();
//        this.rua = enderecoViaCep.getRua();
//    }
}
