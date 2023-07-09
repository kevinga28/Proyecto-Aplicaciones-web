
package com.proyecto.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.entities.Usuario;
import com.proyecto.db.IUsuarioRepository;
import com.proyecto.service.IUsuarioService;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    private IUsuarioRepository iusuarioRepository;
    
    @Override
    public Usuario findByEmail(String email) {
        return iusuarioRepository.findByEmail(email);
    }
    
    @Override
    public Usuario save(Usuario usuario) {
        return iusuarioRepository.save(usuario);
    }
    @Override
	public List<Usuario> listarUsuarios() {
	  return (List<Usuario>) this.iusuarioRepository.findAll();
	}
}
//import java.util.List;
//import com.proyecto.service.IUsuarioService;
//import com.proyecto.entities.Usuario;
//import com.proyecto.db.IUsuarioRepository;
//import com.proyecto.registro.UsuarioRegistro;
//import java.util.Collections;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;


//@Service
//public class UsuarioService implements IUsuarioService {
//    private IUsuarioRepository iusuarioRepository;
//    
//    @Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//    
//    public UsuarioService (IUsuarioRepository iusuarioRepository) {
//		super();
//		this.iusuarioRepository = iusuarioRepository;
//	}
//    @Override
//	public  Usuario guardar(UsuarioRegistro registro) {
//       Usuario usuario = new Usuario(registro.getNombre(), 
//				registro.getApellido(),registro.getEmail(),passwordEncoder.encode(registro.getPassword()));
//       return iusuarioRepository.save(usuario);
//        }
//@Override
//public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    Usuario usuario = iusuarioRepository.findByEmail(username);
//    if (usuario == null) {
//        throw new UsernameNotFoundException("Usuario o contraseña inválidos");
//    }
//    return new User(usuario.getEmail(), usuario.getPassword(), Collections.emptyList());
//}
//@Override
//	public List<Usuario> listarUsuarios() {
//	  return (List<Usuario>) this.iusuarioRepository.findAll();
//	}
//}


