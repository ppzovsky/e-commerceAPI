package br.org.serratec.eCommerce.services;

import br.org.serratec.eCommerce.entities.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    private static final String VIACEP_URL = "https://viacep.com.br/ws/{cep}/json/";

    @Autowired
    private RestTemplate restTemplate;

    public Endereco getCepInfo(String cep) {
        return restTemplate.getForObject(VIACEP_URL, Endereco.class, cep);
    }
}
