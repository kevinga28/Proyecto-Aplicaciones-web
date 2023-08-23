
package Proyecto.Proyecto.controllers;

import Proyecto.Proyecto.entities.Usuario;
import Proyecto.Proyecto.service.IRegistroService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class RegistroController {

    @Autowired
    private IRegistroService registroService;

    @GetMapping("/registro")
    public String nuevo(Model model, Usuario usuario) {
        return "registro"; // No incluir el carácter '/' al principio
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(Model model, @ModelAttribute("usuario") Usuario usuario) 
            throws MessagingException {
        model = registroService.crearUsuario(model, usuario);
        return "registro/salida"; // No incluir el carácter '/' al principio
    }

    @GetMapping("/activacion/{usuario}/{id}")
    public String activar(
            Model model, 
            @PathVariable(value = "usuario") String usuario, 
            @PathVariable(value = "id") String id) {
        model = registroService.activar(model, usuario, id);
        if (model.containsAttribute("usuario")) {
            return "registro/activa"; // No incluir el carácter '/' al principio
        } else {
            return "registro/salida"; // No incluir el carácter '/' al principio
        }
    }

    @PostMapping("/activar")
    public String activar(
            @ModelAttribute("usuario") Usuario usuario, 
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        registroService.activar(usuario, imagenFile);
        return "redirect:/";
    }
}
