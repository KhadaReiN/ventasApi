package edu.unimagdalena.ventasAPI.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "itemsPedidos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class ItemPedido {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Pedido pedidoId;
    private Long productoId;
    private int cantidad;
    private double precioUnitario;

    //Un OrderItem está vinculado a un único Producto y a un único Pedido.
    @OneToOne(mappedBy = "itemsPedidos")
    private Product producto;


    @OneToOne(mappedBy = "itemsPedidos")
    private Pedido pedido;

}
