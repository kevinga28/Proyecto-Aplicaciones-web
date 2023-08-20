
package Proyecto.Proyecto.db;

import Proyecto.Proyecto.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {    
    Usuario findByUsername(String username);
    


}
