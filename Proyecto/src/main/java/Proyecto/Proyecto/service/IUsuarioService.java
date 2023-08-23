
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

    // Se obtiene un Usuario, a partir del username y el password de un usuario
    public Usuario getUsuarioPorUsernameYPassword(String username, String password);
    


    // Se valida si existe un Usuario considerando el username o el correo

    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo);
    
    // Se inserta un nuevo usuario si el id del usuario esta vacío
    // Se actualiza un usuario si el id del usuario NO esta vacío
    public void save(Usuario usuario,boolean crearRolUser);

}