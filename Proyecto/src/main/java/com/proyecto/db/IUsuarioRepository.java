
package com.proyecto.db;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
//import org.springframework.data.repository.CrudRepository;
//import com.proyecto.entities.Usuario;
//public interface IUsuarioRepository extends CrudRepository<Usuario,Long > {
//    	public Usuario findByEmail(String email);
//}
