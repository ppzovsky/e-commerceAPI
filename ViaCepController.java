package br.org.serratec.eCommerce.controllers;

import br.org.serratec.eCommerce.entities.Endereco;
import br.org.serratec.eCommerce.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cep")
public class ViaCepController {

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public Endereco getCepInfo(@PathVariable String cep) {
        return viaCepService.getCepInfo(cep);
    }
}
