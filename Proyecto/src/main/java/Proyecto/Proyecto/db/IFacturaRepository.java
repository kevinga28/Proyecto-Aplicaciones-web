package Proyecto.Proyecto.db;

import Proyecto.Proyecto.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaRepository extends JpaRepository<Factura, Long> {    
    
}
