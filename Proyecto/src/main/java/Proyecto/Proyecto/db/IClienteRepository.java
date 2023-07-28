
package Proyecto.Proyecto.db;

import Proyecto.Proyecto.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteRepository extends CrudRepository<Cliente, Integer> {
}
