
package Proyecto.Proyecto.controllers;
import Proyecto.Proyecto.entities.Cliente;
import Proyecto.Proyecto.service.IClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ClienteController {
    private final IClienteService ClienteService;

    public ClienteController(IClienteService ClienteService) {
        this.ClienteService = ClienteService;
    }

    @GetMapping("/cliente")
    public String index(Model model) {
        var baseCliente = new Cliente();
        model.addAttribute("ClienteDefault", baseCliente);
        model.addAttribute("clientes", this.ClienteService.getAll());
        return "cliente";
    }

}