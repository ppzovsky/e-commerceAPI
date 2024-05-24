package br.org.serratec.eCommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.serratec.eCommerce.Dtos.PedidoResumidoDto;
import br.org.serratec.eCommerce.entities.Pedido;
import br.org.serratec.eCommerce.services.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<Pedido>>findAll(){
		return new ResponseEntity<>(pedidoService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Pedido>findById(@PathVariable Integer id){
		Pedido pedido = pedidoService.findById(id);
		if (pedido == null) {
			return new ResponseEntity<>(pedido, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(pedido, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<Pedido>save(@RequestBody PedidoResumidoDto pedido){
		return new ResponseEntity<>(pedidoService.save(pedido), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Pedido> update (@RequestBody Pedido pedido){
		return new ResponseEntity<>(pedidoService.update(pedido), HttpStatus.OK);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Pedido> delete(@PathVariable Integer id){
		Pedido pedido = pedidoService.findById(id);
		if (pedido == null) {
			return new ResponseEntity<>(pedido,HttpStatus.NOT_FOUND);
		} else {
			pedidoService.delete(id);
			return new ResponseEntity<>(pedido, HttpStatus.OK);
		}
	}
}
