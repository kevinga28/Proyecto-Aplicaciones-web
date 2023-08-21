/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proyecto.Proyecto.service;

import Proyecto.Proyecto.entities.Usuario;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
public interface IRegistroService {

    public Model activar(Model model, String usuario, String clave);

    public Model crearUsuario(Model model, Usuario usuario);
    
    public void activar(Usuario usuario, MultipartFile imagenFile);
    
 
}
