package br.org.serratec.eCommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.eCommerce.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
