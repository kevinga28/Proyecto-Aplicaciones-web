package Proyecto.Proyecto.controllers;

import Proyecto.Proyecto.entities.Product;
import Proyecto.Proyecto.service.IProductService;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String index(Model model, @RequestParam("nombre") Optional<String> nombre) {
        var baseProduct = new Product();
        model.addAttribute("productDefault", baseProduct);
        model.addAttribute("products", this.productService.getAll());
        model.addAttribute("products", this.productService.getProductsWithNombre(nombre));
        return "product";
    }


}
