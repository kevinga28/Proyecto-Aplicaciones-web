
package Proyecto.Proyecto.db;
import Proyecto.Proyecto.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Usuario, Long> {
    
    Usuario findByUsername(String Username);
}

