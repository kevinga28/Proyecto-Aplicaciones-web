
package Proyecto.Proyecto.controllers;

import Proyecto.Proyecto.db.IUsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import Proyecto.Proyecto.entities.Usuario;
import Proyecto.Proyecto.service.IRegistroService;
import Proyecto.Proyecto.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class RegistroController {
     @Autowired
    private IRegistroService registroService;



    @GetMapping("/registro")
    public String registration(Model model) {
        model.addAttribute("userForm", new Usuario());

        return "registration";
    }

    @PostMapping("/registro")
    public String registration(@ModelAttribute("userForm") Usuario userForm, BindingResult bindingResult) {;

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        registroService.save(userForm);


//        return "redirect:/welcome"; ???
    }



	}


