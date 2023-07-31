package Proyecto.Proyecto.service;

import Proyecto.Proyecto.entities.ItemCarrito;
import java.util.List;

public interface IShoppingCartService extends IBaseService<ItemCarrito, Integer> {
    
    List<ItemCarrito> listCartItems();
}