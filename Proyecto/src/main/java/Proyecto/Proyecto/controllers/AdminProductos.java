package Proyecto.Proyecto.controllers;

import Proyecto.Proyecto.entities.Product;
import Proyecto.Proyecto.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminProductos {
    private final IProductService productService;

    public AdminProductos(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/AdminProductos")
    public String index(Model model) {
        var baseProduct = new Product();
        model.addAttribute("productDefault", baseProduct);
        model.addAttribute("products", this.productService.getAll());
        return "AdminProductos";
    }

}