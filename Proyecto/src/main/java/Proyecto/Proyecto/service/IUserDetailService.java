
package Proyecto.Proyecto.service;


import Proyecto.Proyecto.entities.Usuario;
//import Proyecto.Proyecto.entities.dto.UsuarioRegistro;
import java.util.List;
import org.springframework.security.core.userdetails.*;

public interface IUserDetailService {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
}
    
//    public Usuario guardar(UsuarioRegistro registroDTO);
//	public List<Usuario> listarUsuarios();

