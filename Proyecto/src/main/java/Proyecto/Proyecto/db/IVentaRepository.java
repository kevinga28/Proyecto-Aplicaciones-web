package Proyecto.Proyecto.db;

import Proyecto.Proyecto.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository<Venta, Long> {    
    
}
