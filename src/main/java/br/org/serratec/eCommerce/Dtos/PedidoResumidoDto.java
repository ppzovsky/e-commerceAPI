package br.org.serratec.eCommerce.Dtos;

import java.sql.Date;
import java.util.List;

import br.org.serratec.eCommerce.entities.Cliente;
import br.org.serratec.eCommerce.entities.ItemPedido;

public class PedidoResumidoDto {
	
	private Integer idPedido;
	private Date dataPedido;
	private Date dataEntrega;
	private Date dataEnvio;
	private Cliente cliente;
	private List<ItemPedido> itemPedido;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

}