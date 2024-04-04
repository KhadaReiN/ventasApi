package edu.unimagdalena.ventasAPI.repository;

import edu.unimagdalena.ventasAPI.entidades.Cliente;
import edu.unimagdalena.ventasAPI.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    //Buscar pedidos entre dos fecha
    @Query("SELECT p FROM Pedido p WHERE p.fechaPedido between ?1 AND ?2")
    List<Pedido> buscarPedidosEntreDosFechas(LocalDateTime f1, LocalDateTime f2);

    //Buscar pedidos por cliente y un estado
    List<Pedido> findByClientIdAndStatus();

    //Recuperar pedidos con sus artículos usando JOIN fetch para evitar el Problema N+1, para un cliente específico


}
