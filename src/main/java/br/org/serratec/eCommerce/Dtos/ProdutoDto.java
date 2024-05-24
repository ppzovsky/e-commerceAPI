package br.org.serratec.eCommerce.Dtos;

import java.sql.Date;
import java.util.List;

public class ProdutoDto {
	
	private Integer idProduto;
	private String nome;	
	private String descricao;	
	private int qtdEstoque;	
	private Date dataCadastro;	
	private double valorUnitario;	
    private CategoriaResumidoDto categoria;	
	private List<ItemPedidoDto> itemPedido;
	
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public CategoriaResumidoDto getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaResumidoDto categoria) {
		this.categoria = categoria;
	}
	public List<ItemPedidoDto> getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(List<ItemPedidoDto> itemPedido) {
		this.itemPedido = itemPedido;
	}
	
	@Override
	public String toString() {
		return "ProdutoResumidoDto [idProduto=" + idProduto + ", nome=" + nome + ", descricao=" + descricao
				+ ", qtdEstoque=" + qtdEstoque + ", dataCadastro=" + dataCadastro + ", valorUnitario=" + valorUnitario
				+ ", categoria=" + categoria + ", itemPedido=" + itemPedido + "]";
	}	

}