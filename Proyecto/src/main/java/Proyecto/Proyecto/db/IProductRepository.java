
package Proyecto.Proyecto.db;

import Proyecto.Proyecto.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Integer> {
}
