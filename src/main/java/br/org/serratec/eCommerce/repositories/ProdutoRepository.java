package br.org.serratec.eCommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.eCommerce.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
