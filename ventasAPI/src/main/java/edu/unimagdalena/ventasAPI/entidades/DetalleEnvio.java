package edu.unimagdalena.ventasAPI.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detallesEnvios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class DetalleEnvio {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Pedido pedidoId;
    private String direccion;
    private String transportadora;
    @Column(unique = true)
    private String numeroGuia;

    //Los detalles de envío están vinculados a un único pedido.
    @OneToOne(mappedBy = "pedidoId")
    private Pedido pedido;
}
