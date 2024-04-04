package edu.unimagdalena.ventasAPI.repository;

import edu.unimagdalena.ventasAPI.Status;
import edu.unimagdalena.ventasAPI.entidades.DetalleEnvio;
import edu.unimagdalena.ventasAPI.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetalleEnvioRepository  extends JpaRepository<DetalleEnvio, Long> {
    //Buscar los detalles del envío por pedido Id
    List<DetalleEnvio> findByPedidoId(Pedido pedidoId);

    //Buscar los detalles de envío para un transportadora
    List<DetalleEnvio> findByTransportadora(String transportadora);

    //Buscar los detalles de envio por estado
    @Query("SELECT d FROM DetalleEnvio d WHERE EXISTS (SELECT p FROM Pedido p WHERE p.detalleEnvio = d AND p.status = :status)")
    List<DetalleEnvio> findByStatus(Status status);





}
