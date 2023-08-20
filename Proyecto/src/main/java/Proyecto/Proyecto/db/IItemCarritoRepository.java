package Proyecto.Proyecto.db;

import Proyecto.Proyecto.entities.ItemCarrito;
import Proyecto.Proyecto.entities.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IItemCarritoRepository extends CrudRepository<ItemCarrito, Integer> {
    public List<ItemCarrito> findByUsuario(Usuario usuario);
}