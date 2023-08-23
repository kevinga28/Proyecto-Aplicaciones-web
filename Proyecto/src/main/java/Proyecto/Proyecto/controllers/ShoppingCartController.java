package Proyecto.Proyecto.controllers;

import Proyecto.Proyecto.entities.ItemCarrito;
import Proyecto.Proyecto.entities.Product;
import Proyecto.Proyecto.entities.Usuario;
import Proyecto.Proyecto.service.impl.ProductService;
import Proyecto.Proyecto.service.impl.ShoppingCartService;
import Proyecto.Proyecto.service.impl.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ShoppingCartController {
 
    @Autowired
    private ShoppingCartService cartService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private ProductService productService;
 
    @GetMapping("/carrito")
    public String showShoppingCart(Model model, @AuthenticationPrincipal Authentication authentication) {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        if (username.isBlank()) {
            return "carrito";
        }

        Usuario usuario = usuarioService.getUsuarioPorUsername(username);

        if (usuario == null) {
            return "carrito";
        }
        
        List<ItemCarrito> itemsCarrito = this.cartService.listCartItems(usuario);
        var baseItem = new ItemCarrito();
        model.addAttribute("itemsCarrito", itemsCarrito);
        model.addAttribute("itemDefault", baseItem);
        return "carrito";
    }
}
