package com.proyecto.controller;
import com.proyecto.entities.Usuario;
import com.proyecto.service.IUsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LoginController {
    
	 private final IUsuarioService iusuarioService;

    public LoginController(IUsuarioService iusuarioService) {
        this.iusuarioService = iusuarioService;
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
               model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", this.iusuarioService);
        return "login";
    
    }

    @PostMapping("/login")
    public String procesarFormularioLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        boolean credencialesValidas = iusuarioService.verificarCredenciales(email, password);
        if (credencialesValidas) {
            // Realizar acciones adicionales después del inicio de sesión exitoso
            return "redirect:/inicio";
        } else {
            model.addAttribute("error", "Credenciales inválidas");
            return "login";
        }
    }
}
    

    
