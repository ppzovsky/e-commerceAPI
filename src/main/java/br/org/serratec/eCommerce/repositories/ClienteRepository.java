package br.org.serratec.eCommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.eCommerce.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
