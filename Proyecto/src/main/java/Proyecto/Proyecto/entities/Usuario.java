/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Proyecto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name="usuario")

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;    
    @NotEmpty
    private String username;    
    @NotEmpty
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Rol> roles;
//
//    
//    
//    
//    
//    public Long getId() {
//		return idUsuario;
//	}
//
//	public void setId(Long idUsuario) {
//		this.idUsuario = idUsuario;
//	}
//        public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//        public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public String getApellidos() {
//		return apellidos;
//	}
//
//	public void setApellidos(String apellidos) {
//		this.apellidos = apellidos;
//	}
//
//	public String getCorreo() {
//		return correo;
//	}
//
//	public void setCorreo(String correo) {
//		this.correo = correo;
//	}
//
//	
//
//	public List<Rol> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Rol> roles) {
//		this.roles = roles;
//	}
//
//	public Usuario(Long idUsuario,String username,String password, String nombre, String apellidos, String correo,  List<Rol> roles) {
//		super();
//		this.idUsuario = idUsuario;
//                this.username= username;
//                this.password = password;
//		this.nombre = nombre;
//		this.apellidos = apellidos;
//		this.correo = correo;
//		this.roles = roles;
//	}
//        	public Usuario(String username,String password, String nombre, String apellidos, String correo,  List<Rol> roles) {
//		super();
//                this.username= username;
//                this.password = password;
//		this.nombre = nombre;
//		this.apellidos = apellidos;
//		this.correo = correo;
//		this.roles = roles;
//	}
//
//
//	public Usuario() {
//		
//	}
//    
//    
}
