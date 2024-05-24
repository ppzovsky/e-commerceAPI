package br.org.serratec.eCommerce.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.eCommerce.Dtos.PedidoResumidoDto;
import br.org.serratec.eCommerce.entities.ItemPedido;
import br.org.serratec.eCommerce.entities.Pedido;
import br.org.serratec.eCommerce.repositories.ItemPedidoRepository;
import br.org.serratec.eCommerce.repositories.PedidoRepository;
import br.org.serratec.eCommerce.repositories.ProdutoRepository;
import jakarta.persistence.Table;

@Service
@Table (name = "pedido")
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
    ProdutoRepository produtoRepository;

	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	
	public Pedido findById(Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}
	
	public Pedido save(PedidoResumidoDto pedidoDto) {
		Pedido pedido;
		pedido = modelMapper.map(pedidoDto,Pedido.class);
		if (pedido.getDataEnvio() == null && pedido.getDataEntrega() != null) {
	        throw new IllegalArgumentException("A data de envio não pode ser nula quando a data de entrega está definida.");
	    }else if (pedido.getDataEnvio() != null && pedido.getDataEnvio().isBefore(pedido.getDataPedido())) {
	        throw new IllegalArgumentException("A data de envio não pode ser antes da data do pedido.");
	    }else if (pedido.getDataEntrega() != null && pedido.getDataEntrega().isBefore(pedido.getDataPedido())) {
	        throw new IllegalArgumentException("A data de entrega não pode ser antes da data do pedido.");
	    }else if (pedido.getDataEnvio() != null && pedido.getDataEntrega() != null && pedido.getDataEnvio().isAfter(pedido.getDataEntrega())) {
	        throw new IllegalArgumentException("A data de envio não pode ser depois da data de entrega.");
	    }
		
	    return pedidoRepository.save(pedido);
	}
	
	public Pedido update(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public Pedido delete(Integer id) {
		if (pedidoRepository.existsById(id) == true) {
			Pedido pedidoDeletado = pedidoRepository.findById(id).orElse(null);
			try {
				pedidoRepository.deleteById(id);
				return pedidoDeletado;
			} catch (Exception e) {
			 System.out.println(e);
			 return null;
			}
		}
		return null;
	}
	
}
