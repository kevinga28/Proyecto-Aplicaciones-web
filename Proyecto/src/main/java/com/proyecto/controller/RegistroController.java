package com.proyecto.controller;



import com.proyecto.entities.Usuario;
import com.proyecto.service.IUsuarioService;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class RegistroController {

	private final IUsuarioService iusuarioService;

    public RegistroController(IUsuarioService iusuarioService) {
        this.iusuarioService = iusuarioService;
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", this.iusuarioService);
        return "registro";
    }

    @PostMapping("/registro")
    public String procesarFormularioRegistro(@RequestParam("email") String email, @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("password") String password, Model model) {
        Usuario usuarioExistente = iusuarioService.findByEmail(email);
        if (usuarioExistente != null) {
            model.addAttribute("error", "Ya existe un usuario con ese correo electrónico");
            return "registro";
        } else {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setEmail(email);
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setApellido(apellido);
            nuevoUsuario.setPassword(password);
            iusuarioService.registrarUsuario(nuevoUsuario);
            // Realizar acciones adicionales después del registro exitoso
            return "redirect:/inicio";
        }
    }
}