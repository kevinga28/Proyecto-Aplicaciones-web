/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proyecto.Proyecto.service;

import Proyecto.Proyecto.entities.Usuario;

/**
 *
 * @author XPC
 */
public interface IRegistroService {
        void save(Usuario user);

    Usuario findByUsername(String username);
}
