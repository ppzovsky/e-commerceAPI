package br.org.serratec.eCommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.eCommerce.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
