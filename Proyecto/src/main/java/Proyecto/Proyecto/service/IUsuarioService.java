
package Proyecto.Proyecto.service;


import Proyecto.Proyecto.entities.Usuario;
import java.util.List;



public interface IUsuarioService {
    
    
    // Se obtiene un listado de usuarios en un List
    public List<Usuario> getUsuarios();
    
    // Se obtiene un Usuario, a partir del id de un usuario
    public Usuario getUsuario(Usuario usuario);
    
    // Se obtiene un Usuario, a partir del username de un usuario
    public Usuario getUsuarioPorUsername(String username);
    
//    public Usuario createUser(Usuario user);

    
}