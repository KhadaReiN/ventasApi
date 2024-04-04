package edu.unimagdalena.ventasAPI.entidades;

import edu.unimagdalena.ventasAPI.MetodoPago;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Pedido pedidoId;
    private double totalPago;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaPago;
    private MetodoPago metodoPago;

    //Un pago está vinculado a un único pedido.zz
    @OneToOne(mappedBy = "pagos")
    private Pedido pedido;
}
