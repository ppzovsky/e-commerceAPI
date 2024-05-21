package br.org.serratec.eCommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.eCommerce.entities.Endereco;
import br.org.serratec.eCommerce.services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> resgataEnderecos(){
		 return new ResponseEntity<>(enderecoService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Integer id){
        Endereco endereco = enderecoService.findById(id);
        if (endereco == null){
            return new ResponseEntity<>(endereco, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<Endereco> criaEndereco(@RequestBody Endereco endereco) {
        return new ResponseEntity<>(enderecoService.save(endereco), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Endereco> update(@RequestBody Endereco endereco) {
        return new ResponseEntity<>(enderecoService.update(endereco), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Endereco> deletaEndereco(@PathVariable Integer id) {
        Endereco endereco = enderecoService.findById(id);
        if (endereco == null){
            return new ResponseEntity<>(endereco, HttpStatus.NOT_FOUND);
        }
        else {
            enderecoService.delete(id);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        }
    }
}

