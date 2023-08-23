/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Proyecto.service.impl;

import Proyecto.Proyecto.db.IRolRepository;
import Proyecto.Proyecto.db.IUsuarioRepository;
import Proyecto.Proyecto.entities.Usuario;
import Proyecto.Proyecto.service.IRegistroService;
import Proyecto.Proyecto.service.IUsuarioService;
import jakarta.mail.MessagingException;
import java.util.HashSet;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RegistroService implements IRegistroService {

    @Autowired
    private CorreoService correoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MessageSource messageSource;  //creado en semana 4...



    @Override
    public Model activar(Model model, String username, String clave) {
        Usuario usuario
                = usuarioService.getUsuarioPorUsernameYPassword(username,
                        clave);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
        } else {
            model.addAttribute(
                    "titulo",
                    messageSource.getMessage(
                            "registro.activar",
                            null, Locale.getDefault()));
            model.addAttribute(
                    "mensaje",
                    messageSource.getMessage(
                            "registro.activar.error",
                            null, Locale.getDefault()));
        }
        return model;
    }

    @Override
    public void activar(Usuario usuario, MultipartFile imagenFile) {
        var codigo = new BCryptPasswordEncoder();
        usuario.setPassword(codigo.encode(usuario.getPassword()));
        usuario.setActivo(true);


        usuarioService.save(usuario, true);
    }

    @Override
    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException {
        String mensaje;
        if (!usuarioService.
                existeUsuarioPorUsernameOCorreo(
                        usuario.getUsername(),
                        usuario.getCorreo())) {
            String clave = "123";
            usuario.setPassword(clave);
            usuario.setActivo(false);
            usuarioService.save(usuario, true);
            enviaCorreoActivar(usuario, clave);
            mensaje = String.format(
                    messageSource.getMessage(
                            "registro.mensaje.activacion.ok",
                            null,
                            Locale.getDefault()),
                    usuario.getCorreo());
        } else {
            mensaje = String.format(
                    messageSource.getMessage(
                            "registro.mensaje.usuario.o.correo",
                            null,
                            Locale.getDefault()),
                    usuario.getUsername(), usuario.getCorreo());
        } 
        model.addAttribute(
                "titulo",
                messageSource.getMessage(
                        "registro.activar",
                        null,
                        Locale.getDefault()));
        model.addAttribute(
                "mensaje",
                mensaje);
        return model;
    }

    


    //Ojo cómo le lee una informacion del application.properties
    @Value("${servidor.http}")
    private String servidor;

    private void enviaCorreoActivar(Usuario usuario, String clave) throws MessagingException {
        String mensaje = messageSource.getMessage(
                "registro.correo.activar",
                null, Locale.getDefault());
        mensaje = String.format(
                mensaje, usuario.getNombre(),
                usuario.getApellidos(), servidor,
                usuario.getUsername(), clave);
        String asunto = messageSource.getMessage(
                "registro.mensaje.activacion",
                null, Locale.getDefault());
        correoService.enviarCorreoHtml(usuario.getCorreo(), asunto, mensaje);
    }

   
}
