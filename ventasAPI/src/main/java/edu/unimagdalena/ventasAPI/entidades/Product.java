package edu.unimagdalena.ventasAPI.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Product {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @Column(nullable = false)
    private double precio;
    private int stock;

    //Un producto puede formar parte de varios artículos de pedido.
    @OneToMany(mappedBy = "productos")
    private List<ItemPedido> itemPedidos;


}
