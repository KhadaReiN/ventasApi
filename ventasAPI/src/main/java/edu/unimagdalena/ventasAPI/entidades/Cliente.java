package edu.unimagdalena.ventasAPI.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Cliente {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = false, nullable = false)
    private String direccion;

    @OneToMany(mappedBy = "cliente",orphanRemoval = true)
    private List<Pedido> pedidos;
}
