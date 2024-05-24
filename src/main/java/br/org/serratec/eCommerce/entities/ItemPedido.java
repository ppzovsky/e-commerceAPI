package br.org.serratec.eCommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "itemPedido")
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private Integer idItemPedido;

	@NotNull
	@Column(name = "quantidade")
	private int quantidade;

	@NotNull
	@Column(name = "preco_venda")
	private Double precoVenda;

	@Min(0)
	@Max(100)
	@NotNull
	@Column(name = "percentual_desconto")
	private int percentualDesconto;

	@NotNull
	@Column(name = "valor_bruto")
	private Double valorBruto;

	@NotNull
	@Column(name = "valor_liquido")
	private Double valorLiquido;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	public ItemPedido() {
	}

	public ItemPedido(Integer idItemPedido, int quantidade, Double precoVenda, int percentualDesconto,
			Double valorBruto, Double valorLiquido) {
		this.idItemPedido = idItemPedido;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.percentualDesconto = percentualDesconto;
		this.valorBruto = valorBruto;
		this.valorLiquido = valorLiquido;
	}

	public Integer getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoVenda() {
		return produto.getValorUnitario();
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public int getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(int percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Double getValorBruto() {
		return validaValorBruto();
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getValorLiquido() {
		return validaValorLiquido();
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Double validaValorBruto() {
		//testar com parametro Produto produto
		Double valor = getQuantidade() * produto.getValorUnitario();
		return valor;
	}
	
	public Double validaValorLiquido() {
		 Double valor = getValorBruto()-(((getPercentualDesconto()) / 100.0)*getValorBruto());
		return valor;
	}
}