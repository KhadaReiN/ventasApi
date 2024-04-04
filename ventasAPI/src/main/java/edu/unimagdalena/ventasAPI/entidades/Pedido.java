package edu.unimagdalena.ventasAPI.entidades;


import edu.unimagdalena.ventasAPI.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Pedido {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Cliente clientId;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaPedido;
    private Status status;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itemsPedidos;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private  Cliente cliente;



}
