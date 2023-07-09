
package com.proyecto.service;

import com.proyecto.entities.Usuario;
import java.util.List;

public interface IUsuarioService {
    Usuario findByEmail(String email);
    Usuario save(Usuario usuario);
    public List<Usuario> listarUsuarios();
}
//import java.util.List;
//
//import com.proyecto.registro.UsuarioRegistro;
//import com.proyecto.entities.Usuario;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//

//public interface IUsuarioService extends UserDetailsService {

//	public Usuario guardar(UsuarioRegistro registro);
//	
//	public List<Usuario> listarUsuarios();
//	
//}
    
