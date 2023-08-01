package Proyecto.Proyecto.service.impl;

import Proyecto.Proyecto.db.IItemCarritoRepository;
import Proyecto.Proyecto.entities.ItemCarrito;
import Proyecto.Proyecto.entities.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartService {

    @Autowired
    private IItemCarritoRepository cartRepo;

    public List<ItemCarrito> listCartItems(Usuario usuario) {
        return cartRepo.findByUsuario(usuario);
    }
}