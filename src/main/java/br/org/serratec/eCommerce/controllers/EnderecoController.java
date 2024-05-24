package br.org.serratec.eCommerce.controllers;

import br.org.serratec.eCommerce.entities.Endereco;
import br.org.serratec.eCommerce.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        return new ResponseEntity<>(enderecoService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping ("/{id}")
	public ResponseEntity<Endereco>findById(@PathVariable Integer id){
		Endereco endereco = enderecoService.findById(id);
		if (endereco == null) {
			return new ResponseEntity<>(endereco, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(endereco, HttpStatus.OK);
		}
	}

    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody Map<String, String> request) {
        String cep = request.get("cep");
        if (cep == null || !cep.matches("\\d{8}")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Endereco endereco = new Endereco();
        endereco.setComplemento(request.get("complemento"));
        
        try {
            endereco.setNumero(Integer.parseInt(request.get("numero")));
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(enderecoService.save(cep, endereco), HttpStatus.CREATED);
    }
    
    @PutMapping
	public ResponseEntity<Endereco> update (@RequestBody Endereco endereco){
		return new ResponseEntity<>(enderecoService.update(endereco), HttpStatus.OK);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Endereco> delete(@PathVariable Integer id){
		Endereco endereco = enderecoService.findById(id);
		if (endereco == null) {
			return new ResponseEntity<>(endereco,HttpStatus.NOT_FOUND);
		} else {
			enderecoService.delete(id);
			return new ResponseEntity<>(endereco, HttpStatus.OK);
		}
	}
}
