package Proyecto.Proyecto.controllers;

import Proyecto.Proyecto.service.impl.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCartController {
 
    @Autowired
    private ShoppingCartService cartService;
 
    @GetMapping("/cart")
    public String showShoppingCart(Model model) {
        return "carrito";
    }
}
