package edu.unimagdalena.ventasAPI.repository;

import edu.unimagdalena.ventasAPI.entidades.ItemPedido;
import edu.unimagdalena.ventasAPI.entidades.Pedido;
import edu.unimagdalena.ventasAPI.entidades.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemPedidoRepository  extends JpaRepository<ItemPedido, Long> {

    //Buscar Items del pedido por Pedido Id

    //Buscar items del pedido para un producto específico
    //Calcular la suma del total de ventas para un producto, utilice la agregación SUM
    List<ItemPedido> findByPedidoId(Pedido pedidoId);
    List<ItemPedido> findByProductId(Product productoId);
    @Query("SELECT SUM(i.cantidad) FROM ItemPedido i WHERE i.productoId = :producto")
    Integer calcularTotalVentasDeProduct(Product producto);

}
