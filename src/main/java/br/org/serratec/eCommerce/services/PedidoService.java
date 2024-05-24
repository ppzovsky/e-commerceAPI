package br.org.serratec.eCommerce.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.eCommerce.Dtos.PedidoResumidoDto;
import br.org.serratec.eCommerce.entities.Pedido;
import br.org.serratec.eCommerce.repositories.PedidoRepository;
import jakarta.persistence.Table;

@Service
@Table (name = "pedido")
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	
	public Pedido findById(Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}
	
	public Pedido save(PedidoResumidoDto pedidoDto) {
		Pedido pedido = null;
		pedido = modelMapper.map(pedidoDto,Pedido.class);
		if(pedido.getDataEnvio() == null || pedido.getDataEntrega() == null) {
			return pedidoRepository.save(pedido);
		}
		if(pedido.getDataEnvio().isBefore(pedido.getDataPedido()) 
				|| pedido.getDataEntrega().isBefore(pedido.getDataPedido()) 
				|| pedido.getDataEnvio().isAfter(pedido.getDataEntrega())
				|| (pedido.getDataEnvio()==null && pedido.getDataEntrega()!=null)) {
			throw new IllegalArgumentException("Tem certeza dessa data aí, irmão?");
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
