
package Proyecto.Proyecto.service;


import Proyecto.Proyecto.entities.Usuario;
//import Proyecto.Proyecto.entities.dto.UsuarioRegistro;
import java.util.List;


public interface IUserService {
 public List<Usuario> getUsuarios();
  public Usuario getUsuario(Usuario usuario);
     public void save(Usuario usuario,boolean crearRolUser);
}
    

