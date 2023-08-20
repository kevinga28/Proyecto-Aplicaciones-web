package Proyecto.Proyecto.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
    public PerfilController() {
    }

    @GetMapping()
    public String index() {
        return "perfil";
    }
}