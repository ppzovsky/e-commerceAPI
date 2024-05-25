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

import br.org.serratec.eCommerce.entities.ItemPedido;
import br.org.serratec.eCommerce.services.ItemPedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/itens-pedidos")
public class ItemPedidoController {
	
	@Autowired
	ItemPedidoService itemPedidoService;
	
	@Operation(description = "Busca todos")
	@GetMapping
	public ResponseEntity<List<ItemPedido>>findAll(){
		return new ResponseEntity<>(itemPedidoService.findAll(), HttpStatus.OK);
	}
	
	@Operation(description = "Busca pelo Id")
	@GetMapping ("/{id}")
	public ResponseEntity<ItemPedido>findById(@PathVariable Integer id){
		ItemPedido itemPedido = itemPedidoService.findById(id);
		if (itemPedido == null) {
			return new ResponseEntity<>(itemPedido, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(itemPedido, HttpStatus.OK);
		}
	}
	
	@Operation(description = "Cria os dados")
	@PostMapping
	public ResponseEntity<ItemPedido>save(@RequestBody ItemPedido itemPedido){
		return new ResponseEntity<>(itemPedidoService.save(itemPedido), HttpStatus.CREATED);
	}
	
	@Operation(description = "Altera os dados")
	@PutMapping
	public ResponseEntity<ItemPedido> update (@RequestBody ItemPedido itemPedido){
		return new ResponseEntity<>(itemPedidoService.update(itemPedido), HttpStatus.OK);
	}
	
	@Operation(description = "Deleta os dados por Id")
	@DeleteMapping ("/{id}")
	public ResponseEntity<ItemPedido> delete(@PathVariable Integer id){
		ItemPedido itemPedido = itemPedidoService.findById(id);
		if (itemPedido == null) {
			return new ResponseEntity<>(itemPedido,HttpStatus.NOT_FOUND);
		} else {
			itemPedidoService.delete(id);
			return new ResponseEntity<>(itemPedido, HttpStatus.OK);
		}
	}
}
