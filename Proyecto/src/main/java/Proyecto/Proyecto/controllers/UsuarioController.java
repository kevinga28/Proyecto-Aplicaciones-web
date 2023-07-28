
package Proyecto.Proyecto.controllers;
import Proyecto.Proyecto.entities.Usuario;
import Proyecto.Proyecto.service.IUsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UsuarioController {
    private final IUsuarioService UsuarioService;

    public UsuarioController(IUsuarioService UsuarioService) {
        this.UsuarioService = UsuarioService;
    }

    @GetMapping("/usuario")
    public String index(Model model) {
        var baseUsuario = new Usuario();
        model.addAttribute("UsuarioDefault", baseUsuario);
        model.addAttribute("usuarios", this.UsuarioService.getAll());
        return "usuario";
    }

}