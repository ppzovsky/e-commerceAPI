package br.org.serratec.eCommerce.services;

import br.org.serratec.eCommerce.entities.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    private static final String VIACEP_URL = "https://viacep.com.br/ws/{cep}/json/";

    public Endereco getCepInfo(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        Endereco endereco = restTemplate.getForObject(VIACEP_URL, Endereco.class, cep);
        System.out.println("Dados recebidos do ViaCep: " + endereco);
        return endereco;
    }

}
