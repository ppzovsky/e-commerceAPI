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

import br.org.serratec.eCommerce.entities.Categoria;
import br.org.serratec.eCommerce.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria categoria = categoriaService.findById(id);
		if (categoria == null) {
			return new ResponseEntity<>(categoria, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(categoria, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(categoriaService.save(categoria), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(categoriaService.update(categoria), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Categoria> delete(@PathVariable Integer id) {
		Categoria categoria = categoriaService.findById(id);
		if (categoria == null) {
			return new ResponseEntity<>(categoria, HttpStatus.NOT_FOUND);
		} else {
			categoriaService.delete(id);
			return new ResponseEntity<>(categoria, HttpStatus.OK);
		}
	}
	/*
	@GetMapping("/{id}/produto")
	public ResponseEntity<?> findEmprestimoByAlunoId(@PathVariable Integer id){
		Categoria categoria = categoriaService.findById(id);
		List<Produto> produtos = categoriaService.findEmprestimoByAlunoId(id);

		if (categoria == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não registrado!");
		}
		if (produtos == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno sem registros de emprestimos!");
		}
		return new ResponseEntity<>(produtos, HttpStatus.OK);
	}
	*/
}
