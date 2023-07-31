package Proyecto.Proyecto.service.impl;

import Proyecto.Proyecto.db.IItemCarritoRepository;
import Proyecto.Proyecto.entities.ItemCarrito;
import Proyecto.Proyecto.entities.Usuario;
import Proyecto.Proyecto.service.IShoppingCartService;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartService extends BaseService<ItemCarrito, Integer> implements IShoppingCartService {
    public ShoppingCartService(IItemCarritoRepository itemCarritoRepository) {
        super(itemCarritoRepository);
    }
    
    public List<ItemCarrito> listCartItems() {
        return (List<ItemCarrito>) this.repository.findAll();
    }

}
