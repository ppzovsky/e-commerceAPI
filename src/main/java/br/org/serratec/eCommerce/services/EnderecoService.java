package br.org.serratec.eCommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.org.serratec.eCommerce.entities.Endereco;
import br.org.serratec.eCommerce.repositories.EnderecoRepository;

public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;

	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public Endereco findById(Integer id) {
		return enderecoRepository.findById(id).get();
	}

	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Endereco update(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Endereco delete(Integer id) {
		if (enderecoRepository.existsById(id) == true) {
			Endereco excluir = enderecoRepository.findById(id).orElse(null);
			try {
				enderecoRepository.deleteById(id);
				return excluir;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		return null;
	}
}


