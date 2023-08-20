
package Proyecto.Proyecto.service.impl;

import Proyecto.Proyecto.db.IRolRepository;
import Proyecto.Proyecto.db.IUsuarioRepository;
import Proyecto.Proyecto.entities.Rol;
import Proyecto.Proyecto.entities.Usuario;
import Proyecto.Proyecto.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioService implements UserDetailsService, IUsuarioService {

    private final IUsuarioRepository userRepository;
    private final HttpSession session;

    private final IRolRepository roleRepository;

    public UsuarioService(IUsuarioRepository userRepository, HttpSession session, IRolRepository roleRepository) {
        this.userRepository = userRepository;
        this.session = session;
        this.roleRepository = roleRepository;
    }


    
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Busca el usuario por el username en la tabla
        Usuario usuario = this.userRepository.findByUsername(username);
        //Si no existe el usuario lanza una excepción
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        //Si está acá es porque existe el usuario... sacamos los roles que tiene
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()) {   //Se sacan los roles
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        //Se devuelve User (clase de userDetails)
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }    


    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return this.userRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return this.userRepository.findById(usuario.getIdUsuario()).orElse(null);
    }


    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
//
//@Override
//		public Usuario createUser(Usuario user) {
//
//              Rol rol = new Rol();
//            rol.setNombre("ROLE_USER");
//		user.setPassword(user.getPassword());
//		user.setRoles(List<Rol>rol);
//
//		return userRepository.save(user);
//	}

}
