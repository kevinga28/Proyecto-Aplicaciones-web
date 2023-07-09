package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.proyecto.entities.Usuario;
import com.proyecto.service.IUsuarioService;

@Controller
public class RegistroController {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }
    
    @PostMapping("/registro")
    public String doRegistro(Usuario usuario, Model model) {
        Usuario existingUsuario = usuarioService.findByEmail(usuario.getEmail());
        
        if (existingUsuario != null) {
            model.addAttribute("error", "El usuario ya existe");
            return "registro";
        } else {
            usuarioService.save(usuario);
            model.addAttribute("exito", true);
            return "registro";
        }
    }
}

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;

//import com.proyecto.service.IUsuarioService;
//public class RegistroController {
//    
//	@Autowired
//	private IUsuarioService service;
//	
//	@GetMapping("/login")
//	public String iniciarSesion() {
//		return "login";
//	}
//	
//	@GetMapping("/")
//	public String verPaginaDeInicio(Model modelo) {
//		modelo.addAttribute("usuarios", service.listarUsuarios());
//		return "index";
//	}
//}
    
