package br.org.serratec.eCommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "itemPedido")
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private Integer idItemPedido;
	@Column(name = "quantidade")
	private int quantidade;
	@Column(name = "preco_venda")
	private double precoVenda;
	@Column(name = "percentual_desconto")
	private int percentualDesconto;
	@Column(name = "valor_bruto")
	private double valorBruto;
	@Column(name = "valor_liquido")
	private double valorLiquido;

	/*
	 * @ManyToOne
	 * 
	 * @MapsId("idProduto")
	 * 
	 * @JoinColumn(name = "id_produto") private Produto produto;
	 * 
	 * @ManyToOne
	 * 
	 * @MapsId("idPedido")
	 * 
	 * @JoinColumn(name = "id_pedido") private Pedido pedido;
	 */
	public ItemPedido() {
	}

	public ItemPedido(Integer idItemPedido, int quantidade, double precoVenda, int percentualDesconto,
			double valorBruto, double valorLiquido) {
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

	public double getPrecoVenda() {
		return precoVenda;
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

	public double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
}
