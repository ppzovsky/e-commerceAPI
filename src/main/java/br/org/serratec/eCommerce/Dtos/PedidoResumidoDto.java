package br.org.serratec.eCommerce.Dtos;

import java.sql.Date;
import java.util.List;

public class PedidoResumidoDto {
	
	private Integer idPedido;
	private Date dataPedido;
	private Date dataEntrega;
	private Date dataEnvio;
	private Boolean status;
	private double valorTotal;
	private ClienteResumidoDto cliente;
	private List<ItemPedidoResumidoDto> itemPedido;
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public Date getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public ClienteResumidoDto getCliente() {
		return cliente;
	}
	public void setCliente(ClienteResumidoDto cliente) {
		this.cliente = cliente;
	}
	public List<ItemPedidoResumidoDto> getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(List<ItemPedidoResumidoDto> itemPedido) {
		this.itemPedido = itemPedido;
	}
	
	@Override
	public String toString() {
		return "PedidoResumidoDto [idPedido=" + idPedido + ", dataPedido=" + dataPedido + ", dataEntrega=" + dataEntrega
				+ ", dataEnvio=" + dataEnvio + ", status=" + status + ", valorTotal=" + valorTotal + ", cliente="
				+ cliente + ", itemPedido=" + itemPedido + "]";
	}
}