package edu.unimagdalena.ventasAPI.repository;

import edu.unimagdalena.ventasAPI.entidades.Cliente;
import edu.unimagdalena.ventasAPI.entidades.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Cliente, Long> {

    //buscar productos según un término de búsqueda
    Product SearchProductByNombre(String name);

    //Buscar los productos que están en stock

    @Query("SELECT p FROM Product p WHERE p.stock > 0")
    List<Product> productosEnStock();

    //Buscar los productos que no superen un precio y un stock determinado
    @Query("SELECT p FROM Product p WHERE p.precio < ?1 AND p.stock < ?2")
    List<Product> productosQueNoSuperanUnPrecioNiStock();



}
