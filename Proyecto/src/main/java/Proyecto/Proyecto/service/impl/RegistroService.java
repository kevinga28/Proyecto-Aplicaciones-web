/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Proyecto.service.impl;

import Proyecto.Proyecto.db.IRolRepository;
import Proyecto.Proyecto.db.IUsuarioRepository;
import Proyecto.Proyecto.entities.Usuario;
import Proyecto.Proyecto.service.IRegistroService;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author XPC
 */
public class RegistroService implements IRegistroService {
     @Autowired
    private IUsuarioRepository userRepository;
    @Autowired
    private IRolRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
     @Override
    public void save(Usuario user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(roleRepository.findAll()));????
        userRepository.save(user);
    }

    @Override
    public Usuario findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
