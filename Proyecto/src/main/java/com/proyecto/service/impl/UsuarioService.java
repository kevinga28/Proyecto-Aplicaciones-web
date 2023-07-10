
package com.proyecto.service.impl;


import com.proyecto.service.IUsuarioService;
import com.proyecto.entities.Usuario;
import com.proyecto.db.IUsuarioRepository;
import org.springframework.stereotype.Service;



@Service
public class UsuarioService implements IUsuarioService {
    private final IUsuarioRepository iusuarioRepository;

    public UsuarioService(IUsuarioRepository iusuarioRepository) {
        this.iusuarioRepository = iusuarioRepository;
    }

    @Override
    public Usuario findByEmail(String email) {
        return iusuarioRepository.findByEmail(email);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        iusuarioRepository.save(usuario);
    }

    @Override
    public boolean verificarCredenciales(String email, String password) {
        Usuario usuario = findByEmail(email);
        return usuario != null && usuario.getPassword().equals(password);
    }

}
