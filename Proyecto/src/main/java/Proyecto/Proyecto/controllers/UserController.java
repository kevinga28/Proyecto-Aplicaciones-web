/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Proyecto.controllers;


import Proyecto.Proyecto.entities.Usuario;
import Proyecto.Proyecto.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registro")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/registro")
    public String index(Model model) {
        return "/registro";
    }

    @GetMapping
    public String usuarioNuevo(Usuario usuario) {
        return "/usuario/modifica";
    }
    @PostMapping("/guardar")
    public String usuarioGuardar(Usuario usuario,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        userService.save(usuario,true);
        return "redirect:/usuario/listado";
    }
}
