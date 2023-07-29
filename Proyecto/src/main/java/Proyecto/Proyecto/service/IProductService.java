package Proyecto.Proyecto.service;

import Proyecto.Proyecto.entities.Product;
import java.util.List;
import java.util.Optional;

public interface IProductService extends IBaseService<Product, Integer> {
  List<Product> getProductsWithNombre(Optional<String> nombre );
}
