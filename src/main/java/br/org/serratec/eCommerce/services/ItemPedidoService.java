package br.org.serratec.eCommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.eCommerce.entities.ItemPedido;
import br.org.serratec.eCommerce.repositories.ItemPedidoRepository;
import jakarta.persistence.Table;

@Service
@Table (name = "item_pedido")
public class ItemPedidoService {
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	public List<ItemPedido> findAll(){
		return itemPedidoRepository.findAll();
	}
	
	public ItemPedido findById(Integer id) {
		return itemPedidoRepository.findById(id).orElse(null);
	}
	
	public ItemPedido save(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}
	
	public ItemPedido update(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}
	
	public ItemPedido delete(Integer id) {
		if (itemPedidoRepository.existsById(id) == true) {
			ItemPedido itemPedidoDeletado = itemPedidoRepository.findById(id).orElse(null);
			try {
				itemPedidoRepository.deleteById(id);
				return itemPedidoDeletado;
			} catch (Exception e) {
			 System.out.println(e);
			 return null;
			}
		}
		return null;
	}
}
