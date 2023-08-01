/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proyecto.Proyecto.db;

import Proyecto.Proyecto.entities.Rol;
import org.springframework.data.repository.CrudRepository;

public interface IRolRepository  extends CrudRepository<Rol, Long> {
    
}
