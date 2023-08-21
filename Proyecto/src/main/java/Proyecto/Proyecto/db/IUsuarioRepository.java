
package Proyecto.Proyecto.db;

import Proyecto.Proyecto.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {    
    Usuario findByUsername(String username);
    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrCorreo(String username, String correo);

    
    boolean existsByUsernameOrCorreo(String username, String correo);

}
