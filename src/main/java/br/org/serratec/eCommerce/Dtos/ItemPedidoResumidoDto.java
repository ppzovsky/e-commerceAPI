package br.org.serratec.eCommerce.Dtos;

public class ItemPedidoResumidoDto {
	
	private Integer idItemPedido;
	private int quantidade;
	private Double precoVenda;
	private int percentualDesconto;
	private Double valorBruto;
	private Double valorLiquido;
	private ProdutoResumidoDto produto;
	private PedidoResumidoDto pedido;
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
		return precoVenda;
	}
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public int getPercentualDesconto() {
		return percentualDesconto;
	}
	public void setPercentualDesconto(int percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}
	public Double getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}
	public Double getValorLiquido() {
		return valorLiquido;
	}
	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	public ProdutoResumidoDto getProduto() {
		return produto;
	}
	public void setProduto(ProdutoResumidoDto produto) {
		this.produto = produto;
	}
	public PedidoResumidoDto getPedido() {
		return pedido;
	}
	public void setPedido(PedidoResumidoDto pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public String toString() {
		return "ItemPedidoResumidoDto [idItemPedido=" + idItemPedido + ", quantidade=" + quantidade + ", precoVenda="
				+ precoVenda + ", percentualDesconto=" + percentualDesconto + ", valorBruto=" + valorBruto
				+ ", valorLiquido=" + valorLiquido + ", produto=" + produto + ", pedido=" + pedido + "]";
	}	
}