
package Proyecto.Proyecto.service.impl;
import Proyecto.Proyecto.service.IUserDetailService;
import Proyecto.Proyecto.db.IUserRepository;
import Proyecto.Proyecto.entities.Usuario;
import Proyecto.Proyecto.entities.Rol;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailService implements IUserDetailService, UserDetailsService{
    @Autowired
    private IUserRepository userRepository;

    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Busca el usuario por el username de la tabla
        Usuario usuario = userRepository.findByUsername(username);
        //Si no existe el usuario lanza una excepcion
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        //Si está aca es porque existe el usuario... sacamos los roles que tiene
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()) {  //Se sacan los roles
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        //Se devuelve User (clase UserDetails)
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }
}
