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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
//        Usuario usuario = usuarioService.getUsuarioLogueado(authentication);
        Usuario usuario = usuarioService.getUsuarioPorUsername("kevin");
        System.out.println(usuario.toString());
        List<ItemCarrito> itemsCarrito = this.cartService.listCartItems(usuario);
        
//        List<Product> productos = this.productService.getById()
//        List<Product> productos = new ArrayList<Product>();
//        for (int i = 0; i < itemsCarrito.size(); i++) {
//            Optional<Product> product = this.productService.getById(itemsCarrito.get(i).getId());
//            if (product.isPresent()) {
//                productos.add(product.get());
//            }
//        }

//        model.addAttribute("itemsCarrito", productos);
        model.addAttribute("itemsCarrito", itemsCarrito);
        
        return "carrito";
    }
}
