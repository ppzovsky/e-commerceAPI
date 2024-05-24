package br.org.serratec.eCommerce.services;

import br.org.serratec.eCommerce.entities.Endereco;
import br.org.serratec.eCommerce.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }
    
    public Endereco findById(Integer id) {
		return enderecoRepository.findById(id).orElse(null);
	}

    public Endereco save(String cep, Endereco endereco) {
        Endereco enderecoViaCep = viaCepService.getCepInfo(cep);
        if (enderecoViaCep != null) {
            enderecoViaCep.setNumero(endereco.getNumero());
            enderecoViaCep.setComplemento(endereco.getComplemento());
            return enderecoRepository.save(enderecoViaCep);
        } else {
            throw new IllegalArgumentException("CEP não encontrado");
        }
    }
    
    public Endereco update(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
    
    public Endereco delete(Integer id) {
		if (enderecoRepository.existsById(id) == true) {
			Endereco enderecoDeletado = enderecoRepository.findById(id).orElse(null);
			try {
				enderecoRepository.deleteById(id);
				return enderecoDeletado;
			} catch (Exception e) {
			 System.out.println(e);
			 return null;
			}
		}
		return null;
	}

}
