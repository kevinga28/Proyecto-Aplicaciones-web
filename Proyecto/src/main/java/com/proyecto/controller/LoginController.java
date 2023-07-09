package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.proyecto.entities.Usuario;
import com.proyecto.service.IUsuarioService;

@Controller
public class LoginController {
    
    @Autowired
    private IUsuarioService usuarioService;
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
    
    @PostMapping("/login")
    public String doLogin(String email, String password, Model model) {
        Usuario usuario = usuarioService.findByEmail(email);
        
        if (usuario != null && usuario.getPassword().equals(password)) {
            model.addAttribute("usuario", usuario);
            return "home";
        } else {
            model.addAttribute("error", "Credenciales inválidas");
            return "login";
        }
    }
    @GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios",usuarioService.listarUsuarios());
		return "index";
	}
}

//import com.proyecto.registro.UsuarioRegistro;
//import com.proyecto.service.IUsuarioService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/registro")
//public class UsuarioController {
//    private IUsuarioService iusuarioService;
//
//    public UsuarioController(IUsuarioService iusuarioService) {
//        this.iusuarioService = iusuarioService;
//    }
//    
//    @ModelAttribute("usuario")
//	public UsuarioRegistro retornarNuevoUsuarioRegistro() {
//		return new UsuarioRegistro();
//	}
//
//	@GetMapping
//	public String mostrarFormularioDeRegistro() {
//		return "registro";
//	}
//	
//	@PostMapping
//	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistro registro) {
//		iusuarioService.guardar(registro);
//		return "redirect:/registro?exito";
//	}
//    
//}
