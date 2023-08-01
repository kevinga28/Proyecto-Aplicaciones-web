
package Proyecto.Proyecto.service.impl;
import Proyecto.Proyecto.db.IRolRepository;
import Proyecto.Proyecto.db.IUserRepository;
import Proyecto.Proyecto.entities.Usuario;
import Proyecto.Proyecto.entities.Rol;
//import Proyecto.Proyecto.entities.dto.UsuarioRegistro;
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
import Proyecto.Proyecto.service.IUserService;
import java.util.List;

@Service("userDetailsService")
public class UserService implements UserDetailsService, IUserService {

    private final IUserRepository userRepository;
    private final HttpSession session;

    private final IRolRepository roleRepository;

    public UserService(IUserRepository userRepository, HttpSession session, IRolRepository roleRepository) {
        this.userRepository = userRepository;
        this.session = session;
        this.roleRepository = roleRepository;
    }
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
    
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return this.userRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return this.userRepository.findById(usuario.getIdUsuario()).orElse(null);
    }

     @Transactional
    public void save(Usuario usuario, boolean crearRolUser) {
        usuario = this.userRepository.save(usuario);
        if (crearRolUser) {//Si se está creando el usuario, se crea el rol por defecto "USER"
            Rol rol = new Rol();
            rol.setNombre("ROLE_USER");
            rol.setIdUsuario(usuario.getIdUsuario());
            this.roleRepository.save(rol);
        }
    }
}


