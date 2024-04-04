package edu.unimagdalena.ventasAPI.repository;

import edu.unimagdalena.ventasAPI.entidades.Cliente;
import edu.unimagdalena.ventasAPI.entidades.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //Encontrar clientes por email
    Cliente findByEmail(String e);

    //Encontrar clientes por dirección
    Cliente findByDireccion(String d);

    //Encontrar clientes por todos los clientes que comiencen por un nombre
    @Query("SELECT c FROM Cliente c WHERE c.nombre like ?1% , nativeQuery = true")
    List<Cliente> buscarClientesQueComiencenPorUnNombreEspecifico(String n);

    //QDM
    void deleteById(Long id);

    Optional<Cliente> findById(Long id);
}
