
package Proyecto.Proyecto.db;
import Proyecto.Proyecto.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {
}

