package br.org.serratec.eCommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.org.serratec.eCommerce.entities.Cliente;
import br.org.serratec.eCommerce.repositories.ClienteRepository;

public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente findById(Integer id) {
		return clienteRepository.findById(id).get();
	}

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente update(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente delete(Integer id) {
		if (clienteRepository.existsById(id) == true) {
			Cliente excluir = clienteRepository.findById(id).orElse(null);
			try {
				clienteRepository.deleteById(id);
				return excluir;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		return null;
	}
}

