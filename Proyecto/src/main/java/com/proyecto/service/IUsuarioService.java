
package com.proyecto.service;

import com.proyecto.entities.Usuario;

public interface IUsuarioService  {

 Usuario findByEmail(String email);

    void registrarUsuario(Usuario usuario);
    
    boolean verificarCredenciales(String email, String password);
	
}
    
