package edu.unimagdalena.ventasAPI.repository;

import edu.unimagdalena.ventasAPI.entidades.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PagoRepository  extends JpaRepository<Pago, Long> {

    //Recuperar pagos dentro de un rango de fecha
    @Query("SELECT p FROM Pago p WHERE p.fechaPago BETWEEN ?1 AND ?2")
    List<Pago> RecuperarPagosDentroDeUnRangoDeFecha(LocalDateTime f1, LocalDateTime f2);


    //Recuperar pagos por un identificador de una orden y método de pago
    List<Pago> findByPedidoIdAndMetodoPago();
}
