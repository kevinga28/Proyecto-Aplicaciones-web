
package Proyecto.Proyecto.db;

import Proyecto.Proyecto.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface IProductRepository extends CrudRepository<Product, Integer> {
    
//        @Query("SELECT * From producto p WHERE upper(p.nombre) Like%?1%")
//    List<Product> findAll(String nombre);
  List<Product>findAllByNombre(String nombre);
}
